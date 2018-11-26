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

import com.qa.persistence.domain.Recipe;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class RecipeDBRepository implements RecipeRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllRecipes() {
		Query query = manager.createQuery("Select a FROM Recipe a");
		Collection<Recipe> recipes = (Collection<Recipe>) query.getResultList();
		return util.getJSONForObject(recipes);
	}
		
	@Override
	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
		Recipe aRecipe = util.getObjectForJSON(recipe, Recipe.class);
		manager.persist(aRecipe);
		return "{\"message\": \"Recipe has been successfully added\"}";
	}

	
	@Override
	@Transactional(REQUIRED)
	public String updateRecipe(Long recipeID, String updatedRecipe) {
		Recipe newRecipe = util.getObjectForJSON(updatedRecipe, Recipe.class);
		Recipe oldRecipe = manager.find(Recipe.class, recipeID);
		
		oldRecipe.setRecipeName(newRecipe.getRecipeName());
		oldRecipe.setRecipeType(newRecipe.getRecipeType());
		oldRecipe.setServingSize(newRecipe.getServingSize());
		oldRecipe.setDietryInformation(newRecipe.getDietryInformation());
		
		return "{\"message\": \"Recipe sucessfully updated\"}";
	}
	
	
	@Override
	@Transactional(REQUIRED)
	public String deleteRecipe(Long recipeID) {
		if (manager.find(Recipe.class, recipeID) != null) {
			manager.remove(manager.find(Recipe.class, recipeID));
			return "{\"message\": \"Recipe sucessfully deleted\"}";
		} else
			return "{\"message\": \"Recipe not found\"}";	
	}
}
