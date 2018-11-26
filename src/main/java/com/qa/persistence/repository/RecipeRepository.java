package com.qa.persistence.repository;

public interface RecipeRepository {

	String getAllRecipes();

	String createRecipe(String recipe);

	String updateRecipe(Long recipeID, String updatedRecipe);

	String deleteRecipe(Long recipeID);
}