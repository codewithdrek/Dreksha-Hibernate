package com.luv2Code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;



@Entity
@Table(name="Instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")//DB Table column name
	//private InstructorDetail instructorDetail;:*****{  Name is same written in Instructor Detail model class in mapped By : instructorDetail}
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy = "instructor",cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Course> courseList; 
	
	
	public Instructor() {
	}




	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}




	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}




	public List<Course> getCourseList() {
		return courseList;
	}




	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	
	//add convening method for bi directional
	public void add(Course theCourse) {
		if(courseList== null) {
			courseList = new ArrayList<>();
		}
		
		courseList.add(theCourse);
		theCourse.setInstructor(this);

	}



	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}

}
