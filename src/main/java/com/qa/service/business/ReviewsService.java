package com.qa.service.business;

public interface ReviewsService {

	String getAllRecipes();

	String createRecipe(String recipe);

	String updateRecipe(Long recipeID, String newRecipe);

	String deleteRecipe(Long recipeID);

}