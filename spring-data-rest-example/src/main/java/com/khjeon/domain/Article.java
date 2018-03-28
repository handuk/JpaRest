package com.khjeon.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity//데이터베이스의 테이블과 객체를 연결시켜주는 연결고리
public class Article {

	@Id	@GeneratedValue//id =Pk의역활을 하며 GeneratedValue 는 pk값을 자동증가시켜주는 시퀀스역할을한다
	private int id;

	private String nickname;

	@JsonIgnore // 비밀번호는 client에 전달이 안되도록 한다.(jackson annotation) 전달자체가 안되기때문에 데이터베이스에도 삽입이안된다.
	private String password;

	private String content;

	private Date addDate = new Date();

	@OneToMany(mappedBy = "article")//관계지정 방식이며 1개의 아티클에대한 코멘트는 여러개를 뜻할수있다는 관계지정자이다.
	private List<Comment> comments;

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

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
