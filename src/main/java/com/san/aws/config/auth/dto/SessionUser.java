package com.san.aws.config.auth.dto;

import com.san.aws.domain.user.User;
import lombok.Getter;

import java.io.Serializable;


// '인증된' 사용자 정보만 필요로 함. 그 외 정보들은 필요없으니 name, email, picture만 필드로 선언한다.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }
}
