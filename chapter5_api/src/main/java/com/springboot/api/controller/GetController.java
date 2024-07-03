package com.springboot.api.controller;


import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    // get 형식만 받기

    //스프링 4 이후에 잘 사용하지 않음
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    //http://localhost:8080/api/v1/get-api/name
    //get mapping
    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    //@pathvariable을 활용한 get 메서드 값을 간단히 전달할 때 주로 사용
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String variable) {
        return variable;
    }

    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    //@PathVariable 사용시 어노테이션에 지정한 변수의 이름과 메서드 매개변수의 이름을 동일하게 맞추기 어려울때
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    //@RequestParam을 활용한 Get 메서드 구현
    //퀴리 형식으로 값을 전달 할 경우
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    //퀴리스트링에 어떤 값이 들어올지 모르는 경우
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    //DTO 객체를 활용한 GET 메서드
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}