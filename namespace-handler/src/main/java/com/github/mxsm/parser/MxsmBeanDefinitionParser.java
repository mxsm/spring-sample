package com.github.mxsm.parser;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author mxsm
 * @Date 2019/6/2
 */
public class MxsmBeanDefinitionParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String aClass = element.getAttribute("class");
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(aClass);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        parserContext.getRegistry().registerBeanDefinition(element.getAttribute("name"), beanDefinition);
        return beanDefinition;
    }
}
