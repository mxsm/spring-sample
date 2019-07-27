package com.github.mxsm.nacos.beanpostprocessor;

import com.alibaba.nacos.api.config.ConfigService;
import com.github.mxsm.nacos.BeanTest;
import com.github.mxsm.nacos.annotation.NacosValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mxsm
 * @Date 2019/7/27 23:54
 * description:
 */
public class NacosValueBeanPostProcessor  extends InstantiationAwareBeanPostProcessorAdapter implements MergedBeanDefinitionPostProcessor, EnvironmentAware, BeanFactoryAware {

    private final Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet<>(4);

    private ConfigurableListableBeanFactory beanFactory;

    private final Map<String, InjectionMetadata> injectionMetadataCache = new ConcurrentHashMap<>(256);

    private Environment environment;

    public NacosValueBeanPostProcessor() {
        autowiredAnnotationTypes.add(NacosValue.class);
    }

    /**
     * Callback that supplies the owning factory to a bean instance.
     * <p>Invoked after the population of normal bean properties
     * but before an initialization callback such as
     * {@link InitializingBean#afterPropertiesSet()} or a custom init-method.
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     *                    The bean can immediately call methods on the factory.
     * @throws BeansException in case of initialization errors
     * @see BeanInitializationException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        Assert.isInstanceOf(ConfigurableListableBeanFactory.class, beanFactory,
                "AnnotationInjectedBeanPostProcessor requires a ConfigurableListableBeanFactory");
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;

    }


    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {



        InjectionMetadata metadata = findNacosValueMetadata(beanName, bean.getClass(), pvs);
        try {
            metadata.inject(bean, beanName, pvs);
        }
        catch (BeanCreationException ex) {
            throw ex;
        }
        catch (Throwable ex) {
            throw new BeanCreationException(beanName, "Injection of autowired dependencies failed", ex);
        }
        return pvs;

    }

    private InjectionMetadata findNacosValueMetadata(String beanName, Class<?> clazz, @Nullable PropertyValues pvs) {

        String cacheKey = (StringUtils.hasLength(beanName) ? beanName : clazz.getName());

        InjectionMetadata metadata = this.injectionMetadataCache.get(cacheKey);
        if (InjectionMetadata.needsRefresh(metadata, clazz)) {
            synchronized (this.injectionMetadataCache) {
                metadata = this.injectionMetadataCache.get(cacheKey);
                if (InjectionMetadata.needsRefresh(metadata, clazz)) {
                    if (metadata != null) {
                        metadata.clear(pvs);
                    }
                    metadata = buildNacosValueMetadata(clazz);
                    this.injectionMetadataCache.put(cacheKey, metadata);
                }
            }
        }
        return metadata;
    }

    private InjectionMetadata buildNacosValueMetadata(final Class<?> clazz) {
        List<InjectionMetadata.InjectedElement> elements = new ArrayList<>();
        Class<?> targetClass = clazz;
        do {
            final List<InjectionMetadata.InjectedElement> currElements = new ArrayList<>();

            ReflectionUtils.doWithLocalFields(targetClass, field -> {
                AnnotationAttributes ann = findAutowiredAnnotation(field);
                if (ann != null) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        return;
                    }
                    currElements.add(new NacosValueFieldElement(field));
                }
            });
            elements.addAll(0, currElements);
            targetClass = targetClass.getSuperclass();
        }
        while (targetClass != null && targetClass != Object.class);

        return new InjectionMetadata(clazz, elements);
    }

    @Nullable
    private AnnotationAttributes findAutowiredAnnotation(AccessibleObject ao) {
        if (ao.getAnnotations().length > 0) {  // autowiring annotations have to be local
            for (Class<? extends Annotation> type : this.autowiredAnnotationTypes) {
                AnnotationAttributes attributes = AnnotatedElementUtils.getMergedAnnotationAttributes(ao, type);
                if (attributes != null) {
                    return attributes;
                }
            }
        }
        return null;
    }

    /**
     * Set the {@code Environment} that this component runs in.
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * Post-process the given merged bean definition for the specified bean.
     *
     * @param beanDefinition the merged bean definition for the bean
     * @param beanType       the actual type of the managed bean instance
     * @param beanName       the name of the bean
     * @see AbstractAutowireCapableBeanFactory#applyMergedBeanDefinitionPostProcessors
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        InjectionMetadata metadata = findNacosValueMetadata(beanName, beanType, null);
        metadata.checkConfigMembers(beanDefinition);
    }

    /**
     * A notification that the bean definition for the specified name has been reset,
     * and that this post-processor should clear any metadata for the affected bean.
     * <p>The default implementation is empty.
     *
     * @param beanName the name of the bean
     * @see DefaultListableBeanFactory#resetBeanDefinition
     * @since 5.1
     */
    @Override
    public void resetBeanDefinition(String beanName) {

    }

    private class NacosValueFieldElement extends InjectionMetadata.InjectedElement {

        public NacosValueFieldElement(Field field) {
            super(field, null);
        }

        @Override
        protected void inject(Object bean, @Nullable String beanName, @Nullable PropertyValues pvs) throws Throwable {
            Field field = (Field)this.member;

            if (checkPropertySkipping(pvs)) {
                return;
            }

            NacosValue nacosValue = field.getAnnotation(NacosValue.class);
            String resolveDataId = environment.resolvePlaceholders(nacosValue.dataId());
            String resolveGroup = environment.resolvePlaceholders(nacosValue.group());

            ConfigService configService = beanFactory.getBean("nacosConfigService", ConfigService.class);

/*            DependencyDescriptor desc = new DependencyDescriptor(field, true);
            desc.setContainingClass(bean.getClass());
            Set<String> autowiredBeanNames = new LinkedHashSet<>(1);
            Assert.state(beanFactory != null, "No BeanFactory available");
            TypeConverter typeConverter = beanFactory.getTypeConverter();
            try {
                Object value = beanFactory.resolveDependency(desc, beanName, autowiredBeanNames, typeConverter);
                System.out.println("----------" + value);
            }
            catch (BeansException ex) {
                throw new UnsatisfiedDependencyException(null, beanName, new InjectionPoint(field), ex);
            }*/

            ReflectionUtils.makeAccessible(field);
            field.set(bean,configService.getConfig(resolveDataId,resolveGroup,3000));


        }

    }


}
