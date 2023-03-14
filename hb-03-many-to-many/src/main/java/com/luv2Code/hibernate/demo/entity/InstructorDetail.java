package com.luv2Code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@Entity
@Table(name ="Instructor_detail")
public class InstructorDetail {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;

	
	//Bi Directional 
	//@OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH,
		//	CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	//private Instructor instructor;
	
	//mappedBy = "instructorDetail" check in Instructor class this object var name
	@OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.ALL})
	private Instructor instructor;
	
	
	public InstructorDetail() {
	}
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYoutube_channel() {
		return youtubeChannel;
	}
	public void setYoutube_channel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	
	//Add Instructor for BI Code

	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
