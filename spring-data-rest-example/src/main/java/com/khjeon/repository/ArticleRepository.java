package com.khjeon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khjeon.domain.Article;

//왜안되

public interface ArticleRepository extends JpaRepository<Article, Integer> {}
