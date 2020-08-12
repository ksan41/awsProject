package com.san.aws.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@Entity
// Entity : 테이블과 링크될 클래스임을 나타냄.
//          기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭.
//          ex)SalesManager.java => sales_manager table
public class Posts {

    // Id : 해당 테이블의 PK
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    // GeneratedValue : PK의 생성 규칙.
    //                  스프링부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.
    private Long id;

    @Column(length=500, nullable=false)
    // Column: 테이블의 컬럼을 나타냄. 굳이 선언하지 않아도 기본적으로 모두 컬럼이 된다.
    //         기본값 외에 추가로 변경이 필요한 옵션이 있다면 사용.
    //         문자열의 경우 VARCHAR(255)가 기본값. 사이즈를 늘리거나 타입을 변경하고 싶을 경우 사용.
    private String title;

    @Column(columnDefinition="TEXT",nullable=false)
    private String content;

    private String author;
    
    // Builder: 해당 클래스의 빌더 패턴 클래스를 생성(매개변수 생성자로 잘못된 값(null)이 들어오지 않도록 방지
    //          생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author = author;
    }
}
