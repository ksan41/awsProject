package com.san.aws.service.posts;

import com.san.aws.domain.posts.Posts;
import com.san.aws.domain.posts.PostsRepository;
import com.san.aws.web.dto.PostsListResponseDto;
import com.san.aws.web.dto.PostsResponseDto;
import com.san.aws.web.dto.PostsSaveRequestDto;
import com.san.aws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// @RequiredArgsConstructor : final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌.(의존성 주입)
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly=true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
        // .map(PostsListResponseDto::new)
        // ==>  .map(posts -> new PostsListResponseDdto(posts))
        // postsRepository의 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto로 변환, -> List로 반환하는 메소드.
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);

    }
}
