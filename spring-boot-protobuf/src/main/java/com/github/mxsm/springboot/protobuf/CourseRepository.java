package com.github.mxsm.springboot.protobuf;


import com.github.mxsm.springboot.protobuf.ProtobufMessage.Course;
import java.util.Map;

/**
 * @author mxsm
 * @date 2022/1/27 21:05
 * @Since 1.0.0
 */
public class CourseRepository {

    Map<Integer, Course> courses;

    public CourseRepository(Map<Integer, Course> courses) {
        this.courses = courses;
    }

    public Course getCourse(int id) {
        return courses.get(id);
    }
}
