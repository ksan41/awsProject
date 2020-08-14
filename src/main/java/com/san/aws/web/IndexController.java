package com.san.aws.web;

import com.san.aws.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("posts",postsService.findAllDesc());

        // 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환하면 경로와 확장자 자동 지정됨.
        // src/main/resorces/templates/index.mustache 로 전환되어 View Resolver가 처리함
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
