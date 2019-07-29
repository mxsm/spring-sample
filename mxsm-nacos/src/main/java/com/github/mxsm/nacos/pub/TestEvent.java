package com.github.mxsm.nacos.pub;

import org.springframework.context.ApplicationEvent;

/**
 * @author mxsm
 * @Date 2019/7/29 23:52
 * description:
 */
public class TestEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(Object source) {
        super(source);
    }
}
