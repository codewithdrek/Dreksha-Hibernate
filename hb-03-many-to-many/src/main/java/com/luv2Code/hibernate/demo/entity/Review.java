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
	
	@Column(name="comment")
	String comment ;


	//define constructors

	public Review() {
	}

	
	public Review(String comment) {
		this.comment = comment;
	}
	


	//define getter/setter
	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	//define toString
	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	

	
}
