package com.github.mxsm;


import com.github.mxsm.springboot.protobuf.ProtobufMessage.Course;
import com.github.mxsm.springboot.protobuf.SpringProtobufBootstrap;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author mxsm
 * @date 2022/1/27 21:08
 * @Since 1.0.0
 */

@SpringBootTest(classes = SpringProtobufBootstrap.class)
public class ApplicationTest {
    // Other declarations
    private static final String COURSE1_URL = "http://localhost:8080/courses/2";


    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void whenUsingRestTemplate_thenSucceed() {
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new ProtobufHttpMessageConverter());
        restTemplate.setMessageConverters(list);
        ResponseEntity<Course> course = restTemplate.getForEntity(COURSE1_URL, Course.class);
        System.out.println(course.toString());
    }


}
