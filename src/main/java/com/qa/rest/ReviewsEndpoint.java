package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.service.business.ReviewService;

@Path("/Reviews")
public class ReviewsEndpoint {
	
	@Inject 
	private ReviewService service; 
	
	
	@Path("/getAllReviews")
	@GET
	@Produces({ "application/json" })
	public String getAllReviews() {
		return service.getAllReviews();
	}
	
	@Path("/createReview")
	@POST
	@Produces({ "application/json" })
	public String createReview(String review) {
		return service.createReview(review);
	}
	
	@Path("/deleteReview/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteReview(@PathParam("id") Long reviewID) {
		return service.deleteReview(reviewID);
	}
	
	@Path("/updateReview/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateRecipe(@PathParam("id") Long reviewID, String review) {
		return service.updateReview(review, reviewID);
	}
}
