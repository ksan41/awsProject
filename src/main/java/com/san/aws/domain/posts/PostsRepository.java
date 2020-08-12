package com.san.aws.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Dao와 같은 역할을 하는 Repository.
// 인터페이스 생성 후, JpaRepository<Entity클래스, PK타입> 을 상속하면 기본적인
// CRUD 메소드가 자동 생성됨.
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
