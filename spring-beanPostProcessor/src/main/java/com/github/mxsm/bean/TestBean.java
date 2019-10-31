package com.github.mxsm.bean;

import com.github.mxsm.annotation.MxsmValue;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/6/27 23:42
 * description:
 */
@Component
public class TestBean implements InitializingBean {

    @MxsmValue("test")
    private String name;

    public void init(){
        System.out.println("TestBean---init()");
        this.name = "test";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties and satisfied {@link
     * BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an essential property) or if
     *                   initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName()+"-----------afterPropertiesSet---------");
    }
}
