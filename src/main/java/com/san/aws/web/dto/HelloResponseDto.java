package com.san.aws.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 선언된 모든 final필드가 포함된 생성자를 생성해준다.(final이 없는 필드는 포함하지 않음)
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
