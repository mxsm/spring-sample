package com.github.mxsm.nacos.beanfactoryprocessor;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.github.mxsm.nacos.annotation.EnableNacosConfig;
import com.github.mxsm.nacos.beanpostprocessor.NacosValueBeanPostProcessor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Properties;

/**
 * @author mxsm
 * @Date 2019/7/27 19:52
 * description:
 */
public class NacosBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware, BeanFactoryAware {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private BeanFactory beanFactory;

    private Environment environment;

    private ConfigService nacosConfigService;

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
            this.beanFactory = beanFactory;
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
     * Register bean definitions as necessary based on the given annotation metadata of
     * the importing {@code @Configuration} class.
     * <p>Note that {@link BeanDefinitionRegistryPostProcessor} types may <em>not</em> be
     * registered here, due to lifecycle constraints related to {@code @Configuration}
     * class processing.
     *
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry               current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        String annotationName = EnableNacosConfig.class.getName();
        Map<String,Object> metaData = importingClassMetadata.getAnnotationAttributes(annotationName);
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(metaData);

        //获取EnableNacosConfig的globalProperties
        AnnotationAttributes properties = annotationAttributes.getAnnotation("globalProperties");
        if(properties == null){
            if(logger.isErrorEnabled()){
                logger.error(EnableNacosConfig.class.getName()+" globalProperties is null");
            }
            throw new IllegalArgumentException("globalProperties is null");
        }

        //创建ConfigService
        createConfigService(properties,registry);

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(NacosValueBeanPostProcessor.class);
        rootBeanDefinition.setRole(BeanDefinition.ROLE_APPLICATION);
        registry.registerBeanDefinition(NacosValueBeanPostProcessor.class.getName(),rootBeanDefinition);
    }


    private void createConfigService(AnnotationAttributes properties,BeanDefinitionRegistry registry){

        //获取nacos server配置
        String nacosServerAddress = properties.getString("serverAddr");
        String namespace = properties.getString("namespace");
        String resolvedNacosServerAddress = environment.resolvePlaceholders(nacosServerAddress);
        String resolvedNamespace = environment.resolvePlaceholders(namespace);
        if(StringUtils.isEmpty(resolvedNacosServerAddress)){
            if(logger.isWarnEnabled()){
                logger.warn("----------------config nacos Server Address is empty------------------");
            }
            throw new IllegalArgumentException("Nacos Address is empty!");
        }
        if(logger.isInfoEnabled()){
            logger.info("Nacos Config Server [ServerAddress:{},namespace:{}]", resolvedNacosServerAddress,namespace);
        }
        if(this.nacosConfigService == null){
            try {
                Properties clientProperties = new Properties();
                clientProperties.put("serverAddr",resolvedNacosServerAddress);
                clientProperties.put("namespace",resolvedNamespace);
                nacosConfigService = NacosFactory.createConfigService(clientProperties);
                SingletonBeanRegistry singletonBeanRegistry = null;
                if(registry instanceof  SingletonBeanRegistry){
                    singletonBeanRegistry = (SingletonBeanRegistry)registry;
                }
                singletonBeanRegistry.registerSingleton("nacosConfigService",nacosConfigService);

            } catch (NacosException e) {
                logger.error("Create nacos ConfigService Error",e);
                throw new RuntimeException(e);
            }
        }

    }
}
