package com.github.mxsm.nacos.listener;

import com.github.mxsm.nacos.pub.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/7/29 23:59
 * description:
 */
@Component
public class TestListener implements ApplicationListener<TestEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println(event.getSource());
    }
}
