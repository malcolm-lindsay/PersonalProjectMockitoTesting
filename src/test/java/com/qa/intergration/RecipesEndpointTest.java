package com.qa.intergration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.service.business.ReviewsService;
import com.qa.rest.RecipesEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class RecipesEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private RecipesEndpoint endpoint;

	@Mock
	private ReviewsService service;

	

	@Test
	public void testGetAllRecipes() {
		Mockito.when(service.getAllRecipes()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllRecipes());
	}

	@Test
	public void testCreateRecipe() {
		Mockito.when(service.createRecipe(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createRecipe(MOCK_VALUE2));
		Mockito.verify(service).createRecipe(MOCK_VALUE2);
	}

	@Test
	public void testDeleteRecipe() {
		Mockito.when(service.deleteRecipe(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteRecipe(1L));
		Mockito.verify(service).deleteRecipe(1L);
	}

	
	

}



