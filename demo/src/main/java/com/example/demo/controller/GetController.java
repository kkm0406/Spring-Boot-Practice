package com.example.demo.controller;


import com.example.demo.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api") //공통 url
public class GetController {

    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello world";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "Return Name";
    }

    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    //{String 값}과 동일한 이름을 갖는 값이 넘어옴
    public String getVariable1(@PathVariable String variable) {
        return variable; //들어온 string 값을 그대로 return
    }

    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    //{String 값과} 다른 값 사용
    //@PathVariable("variable")에서는 동일한 이름을 사용하고 해당 하는 값이 값으로 넘어옴
    public String getVariable2(@PathVariable("variable") String var) {
        return var; // "/variable2/{variable}"과 값을 일치시킬 수 없을 때
    }

    @GetMapping(value = "/variable23/{variable}/{variable2}/{variable3}")
    //옵셔널한 값에 의해 호출되는 api가 다른 경우 -> 여러 경우의 수에 대비할 때
    public String getVariable23(@PathVariable("variable") String var, @PathVariable("variable2") String var2, @PathVariable("variable3") String var3) {
        return var+" "+var2+" "+var3;
    }


    //http://localhost:8080/api/v1/get-api/request1?name=kkm&email=email@email.com&organization=cbnu
    @GetMapping(value = "/request1")
    //여러 값을 받을 때 (근데, 받는 값이 정해져 있는 경우)
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return name + " " + email + " " + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    //여러 값을 받을 때 (근데, 받는 값이 정해져 있지 않는 경우)
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        //map으로 들어온 param 처리 로직
        param.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return sb.toString();
    }

    //http://localhost:8080/api/v1/get-api/request3?name=kkm&email=email@email.com&organization=cbnu
    @GetMapping(value = "/request3")
    //받는 값을 미리 DTO로 작성
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }


}
