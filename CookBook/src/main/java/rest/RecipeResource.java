package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.omg.CORBA.portable.ApplicationException;

import domain.CookBook;
import domain.Recipe;
import response.CreateRecipeResponse;
import response.RecipeResponse;
import response.RecipesResponse;
import service.AppException;
import service.RecipeService;



@Path("/recipes")
public class RecipeResource {

	@EJB
	private CookBook cookbook;
	
	@EJB
	private RecipeService recipeService;
	

	@GET
	@Produces("application/json")
	public RecipesResponse getRecipesJSON(@DefaultValue("Default User Agent") @HeaderParam ("User-Agent") String userAgent) {
		RecipesResponse response = new RecipesResponse();
		response.setRecipes(cookbook.getRecipes());
		response.setStatusMessage("UserAgent : " + userAgent);
		return response;
	}

	@GET
	@Produces("application/xml")
	public RecipesResponse getRecipesXML() {
		RecipesResponse response = new RecipesResponse();
		response.setRecipes(cookbook.getRecipes());
		return response;
	}

	@GET
	@Path("/{id}")
	public RestResponse getRecipe(@PathParam("id") int id) {

		RecipeResponse response = new RecipeResponse();
		Recipe recipe = null;

		for (Recipe r : cookbook.getRecipes()) {
			if (r.getId() == id) {
				recipe = r;
				break;
			}
		}

		if (recipe == null) {
			response.setStatusCode(1);
			response.setStatusMessage("Ne postoji recept za prosledjeni id.");
		}

		response.setRecipe(recipe);
		return response;
	}

	 
	@GET
	@Produces("application/json")
	public RestResponse getRecipe(
			@DefaultValue("none") @QueryParam("id") String id,
			@DefaultValue("none") @QueryParam("naziv") List<String> name) {
		
		RestResponse response = new RestResponse();
		
		response.setStatusMessage("id : " + id + ", naziv : " + name);
		return response;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestResponse createRecipe(Recipe recipe) {

		try {
			
			int id = recipeService.createRecipe(recipe);
			
			CreateRecipeResponse response = new CreateRecipeResponse();
			response.setId(id);
			response.setRestResponse(ErrorMessages.ok);
			return response;
			
		} catch (AppException ex) {
			
			CreateRecipeResponse response = new CreateRecipeResponse();
			response.setRestResponse(ex.getError());
			return response;
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public RestResponse editRecipe(@PathParam("id") int id, Recipe recipe) {

		RestResponse response = new RestResponse();

		Recipe copy = find(id);
		copy.copyAttributes(recipe);
		return response;
	}

	private Recipe find(int id) {

		for (Recipe r : cookbook.getRecipes()) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public RestResponse deleteRecipe(@PathParam("id") int id) {
		
		Recipe recipe = find(id);
		cookbook.getRecipes().remove(recipe);
		
		return new RestResponse();
	}

}

