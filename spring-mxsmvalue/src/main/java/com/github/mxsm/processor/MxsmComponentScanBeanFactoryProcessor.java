package com.github.mxsm.processor;

import com.github.mxsm.annotation.MxsmComponentScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author mxsm
 * @Date 2019/8/11 16:09
 * description:
 */
@Component
public class MxsmComponentScanBeanFactoryProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     * Modify the application context's internal bean definition registry after its
     * standard initialization. All regular bean definitions will have been loaded,
     * but no beans will have been instantiated yet. This allows for adding further
     * bean definitions before the next post-processing phase kicks in.
     *
     * @param registry the bean definition registry used by the application context
     * @throws BeansException in case of errors
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        if(registry instanceof  ConfigurableListableBeanFactory){
            System.out.println("+++++++++++++");
            ConfigurableListableBeanFactory item =  (ConfigurableListableBeanFactory)registry;

            //item.findAnnotationOnBean();
        }
    }

    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     *
     * @param beanFactory the bean factory used by the application context
     * @throws BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //Map<String, Object> maps =  beanFactory.getBeansWithAnnotation(MxsmComponentScan.class);
        //System.out.println(maps);
    }
}
