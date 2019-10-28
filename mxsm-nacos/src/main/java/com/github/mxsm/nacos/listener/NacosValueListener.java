package com.github.mxsm.nacos.listener;

import com.alibaba.nacos.client.config.listener.impl.PropertiesListener;
import java.util.Properties;

/**
 * @author mxsm
 * @Date 2019/10/28 22:38 description:
 */
public class NacosValueListener extends PropertiesListener {

    /**
     * properties type for receiver
     *
     * @param properties properties
     */
    @Override
    public void innerReceive(Properties properties) {

    }
}
