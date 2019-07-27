package com.github.mxsm.nacos.annotation;

import java.lang.annotation.*;

/**
 * @author mxsm
 * @Date 2019/7/27 19:39
 * description:nacos的Properties
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NacosProperties {

    String PREFIX = "nacos.";

    String SERVER_ADDR = "server-addr";

    String NAMESPACE = "namespace";

    String SERVER_ADDR_PLACEHOLDER = "${" + PREFIX + SERVER_ADDR + ":}";

    String NAMESPACE_PLACEHOLDER = "${" + PREFIX + NAMESPACE + ":public}";

    String serverAddr() default SERVER_ADDR_PLACEHOLDER;

    String namespace() default NAMESPACE_PLACEHOLDER;
}
