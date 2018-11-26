package com.qa.persistence.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID")
	private Long userID;
	
	@Column(length = 10)
	private String userName;
	@Column(length = 10)
	private String dietryRequirements;
	@Column(length = 10)
	private long phoneNumber;
	@Column(length = 10)
	private int age;
	
	@JoinColumn(name ="userID", referencedColumnName = "userID")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	public User() {

	}


	public User(String userName, String dietryRequirements,
			long phoneNumber, int age) {
		this.userName = userName;
		this.dietryRequirements = dietryRequirements;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDietryRequirements(String dietryRequirements) {
		this.dietryRequirements = dietryRequirements;
	}

	public String getDietryRequirements() {
		return dietryRequirements;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
