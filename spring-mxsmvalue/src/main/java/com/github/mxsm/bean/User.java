package com.github.mxsm.bean;

import com.github.mxsm.annotation.MxsmValue;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/7/1 0:40
 * description:
 */
@Component
public class User {

    @MxsmValue("${test}")
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
