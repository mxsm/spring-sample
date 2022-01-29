package com.github.mxsm.springboot.protobuf;

import com.github.mxsm.springboot.protobuf.ProtobufMessage.Student;
import com.google.protobuf.Any;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @date 2022/1/28 17:58
 * @Since 1.0.0
 */
@RestController
public class JsonProtobufController {

    @RequestMapping("/student/{id}")
    Student protobuf(@PathVariable Integer id) {
        return Student.newBuilder().setId(id).setFirstName("maxsm").setLastName("sdfsdfsdfsdfsdfsdsdfsdfsdfsdfsdfsdfsdfsdf")
            .setEmail("1224sdfsfsdf344552@163.com").addPhone(Student.PhoneNumber.newBuilder().setNumber("12345sdfsdfsd6566666").setType(
                Student.PhoneType.MOBILE).build()).build();
    }


    @RequestMapping("/studentjson/{id}")
    StudentJson json(@PathVariable Integer id) {

        StudentJson json = new StudentJson();
        json.setId(id);
        json.setFirstName("maxsm");
        json.setLastName("sdfsdfsdfsdfsdfsd");
        json.setEmail("1224344552@163.com");
        json.setPhoneNumber(new PhoneNumber("123456566666",PhoneType.MOBILE));

        return json;
    }

    @RequestMapping("/studentjsonproto/{id}")
    MessageDto jsonproto(@PathVariable Integer id) {

        StudentJson json = new StudentJson();
        json.setId(id);
        json.setFirstName("maxsm");
        json.setLastName("sdfsdfsdfsdfsdfsd");
        json.setEmail("1224344552@163.com");
        json.setPhoneNumber(new PhoneNumber("123456566666",PhoneType.MOBILE));
        MessageDto.MxsmDto.newBuilder().setDetails(Any.pack(json))

        return json;
    }
}
