package com.github.mxsm.mapper;

import com.github.mxsm.entity.Roles;
import org.apache.ibatis.annotations.Param;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/2/8 13:44
 */
public interface RoleMapper {

    Roles select(@Param("role") String role);

}
