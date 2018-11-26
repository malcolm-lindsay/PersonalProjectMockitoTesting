package com.qa.intergration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.service.business.ReviewService;
import com.qa.rest.ReviewsEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class ReviewsEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private ReviewsEndpoint endpoint;

	@Mock
	private ReviewService service;

	@Test
	public void testGetAllReview() {
		Mockito.when(service.getAllReviews()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllReviews());
	}

	@Test
	public void testCreateReview() {
		Mockito.when(service.createReview(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createReview(MOCK_VALUE2));
		Mockito.verify(service).createReview(MOCK_VALUE2);
	}

	@Test
	public void testDeleteReview() {
		Mockito.when(service.deleteReview(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteReview(1L));
		Mockito.verify(service).deleteReview(1L);
	}
}



