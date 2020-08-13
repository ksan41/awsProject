package com.san.aws.web.dto;

import com.san.aws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    // Entity와 유사한 형태임에도 Dto를 굳이 만드는 이유?
    // Entity는 데이터베이스와 맞닿은 핵심 클래스. 이를 기준으로 테이블이 생성되고, 스키마가 변경 됨.
    // 수많은 서비스 클래스나 비즈니스 로직들이 Entity클래스를 기준으로 동작하기 때문에
    // 변경될 시 여러 클래스에 영향을 끼친다.
    // Controller에서 결괏값으로 여러 테이블을 조인해서 줘야 될 경우도 많음.(Entity만으로는 표현하기 어려울 수 있음)
    // => 절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안된다.
    //    때문에 Request/Response용, 즉 View를 위한 클래스인 Dto를 따로 두는 것.

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
