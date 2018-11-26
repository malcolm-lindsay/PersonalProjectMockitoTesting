package com.qa.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Recipe;
import com.qa.persistence.repository.RecipeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class RecipeDBRepositoryTest {

	@InjectMocks
	private RecipeDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"recipeName\":\"pasta\",\"recipeType\":\"Lunch\",\"servingSize\":\"10\",\"dietryInformation\":\"vegetarian\"}]";
	
	private static final String MOCK_OBJECT = "{\"recipeName\":\"pasta\",\"recipeType\":\"Lunch\",\"servingSize\":\"10\",\"dietryInformation\":\"vegetarian\"}";


	@Test
	public void testGetAllRecipes() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(new Recipe("pasta", "Lunch", 10, "vegetarian"));
		Mockito.when(query.getResultList()).thenReturn(recipes);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllRecipes());
	}

	@Test
	public void testCreateRecipe() {
		String reply = repo.createRecipe(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Recipe has been successfully added\"}");
	}

	@Test
	public void testDeleteRecipe() {
		String reply = repo.deleteRecipe(1L);
		Assert.assertEquals(reply, "{\"message\": \"Recipe sucessfully deleted\"}");
	}
	
}
