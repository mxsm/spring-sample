package com.github.mxsm.nacos.pub;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author mxsm
 * @Date 2019/7/29 23:51
 * description:
 */
@Component
public class ApplicationEventPublisherTest implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void init(){
        applicationEventPublisher.publishEvent(new TestEvent("test"));
    }

    /**
     * Set the ApplicationEventPublisher that this object runs in.
     * <p>Invoked after population of normal bean properties but before an init
     * callback like InitializingBean's afterPropertiesSet or a custom init-method.
     * Invoked before ApplicationContextAware's setApplicationContext.
     *
     * @param applicationEventPublisher event publisher to be used by this object
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
