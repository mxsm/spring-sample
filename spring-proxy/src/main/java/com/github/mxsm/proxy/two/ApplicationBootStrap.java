package com.github.mxsm.proxy.two;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mxsm
 * @date 2021/12/8 22:51
 * @Since 1.0.0
 */
public class ApplicationBootStrap {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
        TeacherService teacherService = context.getBean(TeacherService.class);
        teacherService.testUser();
        System.out.println(teacherService);

    }

}
