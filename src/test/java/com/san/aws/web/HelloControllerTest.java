package com.san.aws.web;

import com.san.aws.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자(SpringRunner)를 실행시킨다.
                             // => 스프링부트 테스트와 JUnit 사이에 연결자 역할을 함.
@WebMvcTest(controllers=HelloController.class,
            excludeFilters = {
            @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,classes = SecurityConfig.class)
            })
// 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션.
// 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.(단, @Service, @Component, @Repository등은 사용불가)
// => 여기서는 컨트롤러만 사용할 것이기 때문에 선언함.
public class HelloControllerTest {

    // 스프링이 관리하는 빈을 주입받음.
    @Autowired
    private MockMvc mvc;
    // 웹 API를 테스트할 때 사용. 스프링 MVC 테스트의 시작점이다.
    // => 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name="hello";
        int amount=1000;

        // .param() : API 테스트 시 사용될 요청 파라미터를 설정.
        //            단, String 값만 허용된다.(다른 데이터 등록 시 String 변환해야 함)
        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
        // jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드
        //            $을 기준으로 필드명을 명시한다.
    }
}
