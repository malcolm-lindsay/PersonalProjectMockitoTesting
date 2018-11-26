package com.qa.persistence.repository;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import java.util.Collection;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.qa.persistence.domain.Review;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ReviewDBRepository implements ReviewRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllReviews() {
		Query query = manager.createQuery("Select a FROM Review a");
		Collection<Review> Reviews = (Collection<Review>) query.getResultList();
		return util.getJSONForObject(Reviews);
	}

	@Override
	@Transactional(REQUIRED)
	public String createReview(String review) {
		Review aReview = util.getObjectForJSON(review, Review.class);
		manager.persist(aReview);
		return "{\"message\": \"Review has been successfully added\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateReview(Long reviewID, String updatedReview) {
		Review newReview = util.getObjectForJSON(updatedReview, Review.class);
		Review oldReview = manager.find(Review.class, reviewID);
		
		oldReview.setReview(newReview.getReview());
		oldReview.setYearOfReview(newReview.getYearOfReview());
		oldReview.setRating(newReview.getRating());

		
		return "{\"message\": \"Review sucessfully edited\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteReview(Long reviewID) {
		if (manager.find(Review.class, reviewID) != null) {
			manager.remove(manager.find(Review.class, reviewID));
			return "{\"message\": \"Review sucessfully deleted\"}";
		} else
			return "{\"message\": \"Review not found\"}";
	}
}


