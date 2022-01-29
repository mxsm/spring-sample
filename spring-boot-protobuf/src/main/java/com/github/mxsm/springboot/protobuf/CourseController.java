package com.github.mxsm.springboot.protobuf;


import com.github.mxsm.springboot.protobuf.ProtobufMessage.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @date 2022/1/27 21:07
 * @Since 1.0.0
 */
@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepo;

    @RequestMapping("/courses/{id}")
    Course customer(@PathVariable Integer id) {
        return courseRepo.getCourse(id);
    }

}
