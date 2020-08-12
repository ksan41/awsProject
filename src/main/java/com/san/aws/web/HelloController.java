package com.san.aws.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
// 각 메소드마다 @ResponseBody를 선언했던 것을 한번에 사용할 수 있게 함.
@RestController
public class HelloController {

    // HTTP Method 요청인 Get(조회)를 받을 수 있는 API를 만들어 준다.
    // 기존에는 @RequestMapping(method=RequestMethod.GET)으로 사용하던 것.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
