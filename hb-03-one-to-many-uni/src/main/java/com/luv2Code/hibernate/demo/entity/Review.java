package com.luv2Code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review  {


	//define filed
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name="comments")
	String comments ;
	
	//define constructors
	public Review(String comments) {
		this.comments = comments;
	}
	
	//define getter/setter

	
	

	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
	//define toString
	@Override
	public String toString() {
		return "Review [id=" + id + ", comments=" + comments + "]";
	}
	
	
	//annotated filed
}
