package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.ReviewDBRepository;

public class ReviewServiceImpl implements ReviewService {

	@Inject
	ReviewDBRepository repo; 
	
	@Override
	public String getAllReviews() {
		return repo.getAllReviews();
	}

	@Override
	public String createReview(String review) {
		return repo.createReview(review);
	}

	@Override
	public String updateReview(String updatedReview, Long reviewID) {
		return repo.updateReview(reviewID, updatedReview);
	}

	@Override
	public String deleteReview(Long reviewID) {
		return repo.deleteReview(reviewID);
	
	}
}
