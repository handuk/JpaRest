package com.khjeon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.khjeon.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@RestResource(path="comment-likenick")
	List<Comment> findByNicknameStartsWith(@Param(value="nickname") String nickname);
	//두개의 차이점은 StartsWith 의차이로서 자동으로 sql문이 생성될때 like를 붙여주는것과 안붙여주는것의 차이이다.
	@RestResource(path="comment-nick")
	List<Comment> findByNickname(@Param(value="nickname") String nickname);
	
	@RestResource(path="article-comment")
	List<Comment> findByArticle_Id(@Param(value = "articleID") int articleID); 


	
	
	
}
