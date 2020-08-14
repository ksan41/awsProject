package com.san.aws.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Dao와 같은 역할을 하는 Repository.
// 인터페이스 생성 후, JpaRepository<Entity클래스, PK타입> 을 상속하면 기본적인
// CRUD 메소드가 자동 생성됨.
public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
