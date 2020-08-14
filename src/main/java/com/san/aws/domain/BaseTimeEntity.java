package com.san.aws.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// MappedSuperclass: JPA Entity 클래스들이 BaseTimeEntity 클래스를 상속할 경우 필드들도 컬럼으로 인식하도록 함.
@EntityListeners(AuditingEntityListener.class)
// EntityListeners: BaseTimeEntity 클래스에 Auditing기능을 포함시킨다.
public class BaseTimeEntity {

    // Entity가 생성되어 저장될 때의 시간이 자동 저장된다.
    @CreatedDate
    private LocalDateTime createDate;

    // 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
