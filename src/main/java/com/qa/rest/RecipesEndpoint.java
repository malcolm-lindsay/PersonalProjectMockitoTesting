package com.qa.rest;
import javax.validation.Valid;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.service.business.ReviewsService;

@Path("/Recipes")
public class RecipesEndpoint {
	
	@Inject 
	private ReviewsService service; 
	
	
	@Path("/getAllRecipes")
	@GET
	@Produces({ "application/json" })
	public String getAllRecipes() {
		return service.getAllRecipes();
	}
	
	
	@Path("/updateRecipe/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateRecipe(@PathParam("id") Long recipeID, String recipe) {
		return service.updateRecipe(recipeID, recipe);
	}
	
	@Path("/createRecipe")
	@POST
	@Produces({ "application/json" })
	public String createRecipe(String recipe) {
		return service.createRecipe(recipe);
	}
	
	@Path("/deleteRecipe/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRecipe(@PathParam("id") Long recipeID) {
		return service.deleteRecipe(recipeID);
	}


}
