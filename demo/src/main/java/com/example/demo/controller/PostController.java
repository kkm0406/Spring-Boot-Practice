package com.example.demo.controller;


import com.example.demo.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //파라미터없이 post
    @PostMapping(value = "default")
    public String postMethod(){
        return "Hello world";
    }

    //http://localhost:8080/api/v1/post-api/member1
    @PostMapping(value = "/member1")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });

        return sb.toString();
    }

    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    //key와 value가 정해져 있지만, 받아야할 파라미터가 많을 경우 DTO객체를 사용한 방식
    public String postMemberDTO(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }

}
