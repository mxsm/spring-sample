package com.github.mxsm.handler;

import com.github.mxsm.parser.MxsmBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MxsmSchemaHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("mxsmBean", new MxsmBeanDefinitionParser());
    }
}
