package com.san.aws.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Target: 어노테이션이 생성될 수 있는 위치를 지정.
//         (현재 PARAMETER로 지정했기 때문에 메소드의 파라미터로 선언된 객체에서만 사용할 수 있다.)
// Retentrion : 어느 범위까지 어노테이션이 영향을 미치는지 지정.
//              RUNTIME: 컴파일 이후에도 JVM에 의해서 참조 가능.
//              CLASS: 컴파일러가 클래스를 참조할 때까지 유효.
//              SOURCE: 어노테이션 정보는 컴파일 이후 없어진다.


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    // @interface : 이 파일을 어노테이션 클래스로 지정.
    //              (@LoginUser로 호출하게 됨)
}
