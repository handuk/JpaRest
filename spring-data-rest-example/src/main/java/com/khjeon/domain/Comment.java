package com.khjeon.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	@Id	@GeneratedValue
	private int id;

	private String nickname;

	@JsonIgnore // 비밀번호는 client에 전달이 안되도록 한다.(jackson annotation)
	private String password;

	private String content;
	
	private Date addDate = new Date();

	@ManyToOne//여러개의 코멘트에대한 아티클은 하나라는 관계지정자이다
	@JoinColumn(name = "ARTICLE_ID")//comment의 Article_id컬럼과 article의 pk를 관계를지어 외래키로 만들어준다는 조인어노테이션
	private Article article;

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
}
