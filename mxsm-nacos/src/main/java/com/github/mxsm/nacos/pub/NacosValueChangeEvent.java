package com.github.mxsm.nacos.pub;

import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.context.ApplicationEvent;

/**
 * @author mxsm
 * @Date 2019/8/3 20:44
 * description:
 */
public class NacosValueChangeEvent extends ApplicationEvent {

   private final String content;

   private final String  key;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NacosValueChangeEvent(Object source, String content, String key) {
        super(source);
        this.content = content;
        this.key = key;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    public String getContent() {
        return content;
    }

    public String getKey() {
        return key;
    }
}
