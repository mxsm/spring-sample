package com.github.mxsm.parser;

import org.springframework.beans.factory.config.BeanDefinition;
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
        System.out.println(element.getAttribute("name")+"-------");
        return null;
    }
}
