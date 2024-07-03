package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 예제 5.10
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post Api";
    }

    //http://localhost:8080/api/v1/post-api/member
    //@RequestBody와 Map을 활용한 Post Api 구현
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //http://localhost:8080/api/v1/post-api/member2
    //DTO 객체를 활용한 Post Api 구현
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}

