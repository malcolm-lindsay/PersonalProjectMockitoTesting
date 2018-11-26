
package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10)
	private Long reviewID;
	@Column(length = 10)
	private String review;
	@Column(length = 10)
	private int yearOfReview;
	@Column(length = 10)
	private Long rating;
	
	@JoinColumn(name = "userID")
	private Long userID;
	@JoinColumn(name = "recipeID")
	private Long recipeID;

	
	public Review() {
	}

	public Review(int yearOfReview, String review, long rating) {
		this.yearOfReview = yearOfReview;
		this.review = review;
		this.rating = rating;
	}

	public Long getReviewID() {
		return reviewID;
	}

	public void setReviewID(Long reviewID) {
		this.reviewID = reviewID;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getYearOfReview() {
		return yearOfReview;
	}

	public void setYearOfReview(int yearOfReview) {
		this.yearOfReview = yearOfReview;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(Long recipeID) {
		this.recipeID = recipeID;
	}	
}

