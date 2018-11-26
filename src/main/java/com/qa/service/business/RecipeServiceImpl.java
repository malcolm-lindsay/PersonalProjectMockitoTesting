package com.qa.service.business;
import javax.inject.Inject;
import com.qa.persistence.repository.RecipeDBRepository;
public class RecipeServiceImpl implements ReviewsService {

	@Inject
	RecipeDBRepository repo;
	
	@Override
	public String getAllRecipes() {
		return repo.getAllRecipes();
	}

	@Override
	public String createRecipe(String recipe) {
		return repo.createRecipe(recipe);
	}

	@Override
	public String updateRecipe(Long recipeID, String newRecipe) {
		return repo.updateRecipe(recipeID, newRecipe);
	}

	@Override
	public String deleteRecipe(Long recipeID) {
		return repo.deleteRecipe(recipeID);
	}
}
