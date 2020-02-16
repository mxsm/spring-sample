package com.github.mxsm;

import com.github.mxsm.entity.Roles;
import com.github.mxsm.mapper.RoleMapper;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 */
public class ApplicationStart {

    public static void main(String[] args) throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        RoleMapper roleMapper = sqlSessionFactory.openSession().getMapper(RoleMapper.class);
        Roles roles = roleMapper.select("ROLE_ADMIN");
        System.out.println(roles.getUsername());
    }
}
