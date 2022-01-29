package com.github.mxsm.springboot.protobuf.config;

import com.github.mxsm.springboot.protobuf.CourseRepository;
import com.github.mxsm.springboot.protobuf.ProtobufMessage.Course;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

/**
 * @author mxsm
 * @date 2022/1/27 20:58
 * @Since 1.0.0
 */
@Configuration
public class Config {

    @Bean
    public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    public CourseRepository createTestCourses() {
        Map<Integer, Course> courses = new HashMap<>();
        Course course1 = Course.newBuilder()
            .setId(1)
            .setCourseName("REST with Spring")
            .addAllStudent(new ArrayList<>())
            .build();
        Course course2 = Course.newBuilder()
            .setId(2)
            .setCourseName("Learn Spring Security")
            .addAllStudent(new ArrayList<>())
            .build();
        courses.put(course1.getId(), course1);
        courses.put(course2.getId(), course2);
        return new CourseRepository(courses);
    }
}
