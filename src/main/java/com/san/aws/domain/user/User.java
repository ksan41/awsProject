package com.san.aws.domain.user;

import com.san.aws.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    // @Enumerated(EnumType.STRING)
    // JPA로 데이터베이스를 저장할 때 Enum 값을 어떤 형태로 저장할지를 결정.
    // (기본값은 int)
    // => 숫자로 저장되면 데이터베이스로 확인 시 그 값이 무슨 코드를 의미하는지 알 수 없기 때문에 문자열로 저장되도록 지정한 것.

    @Builder
    public User(String name,String email,String picture,Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
    }

    public User update(String name,String picture){
        this.name=name;
        this.picture=picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
