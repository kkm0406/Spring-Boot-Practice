package com.example.demo.controller;


import com.example.demo.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//Put API: 해당 리로스가 존재하면 갱신하고, 리소스가 없을 경우에는 새로 생성 
//업데이트를 위한 메소드
//기본적인 동작 방식은 Post API와 동일
@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    //http://localhost:8080/api/v1/put-api/default
    @PutMapping(value = "/default")
    public String putMethod() {
        return "put hello world";
    }

    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String putMember1(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public String putMemberDTO2(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }

    //http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public MemberDTO putMemberDTO3(@RequestBody MemberDTO memberDTO){
        return memberDTO;
    }

    //http://localhost:8080/api/v1/put-api/member4
    @PutMapping(value = "/member4")
    //ResponseEntitiy
    //: Spring Framework에서 제공하는 클래스 중 HttpEntity라는 클래스를 상속받아 사용하는 클래스
    //사용자의 HttpRequest에 대한 응답 데이터를 포함
    //HttpStatus, HttpHeaders, HttpBody
    public ResponseEntity<MemberDTO> putMemberDTO4(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }
}
