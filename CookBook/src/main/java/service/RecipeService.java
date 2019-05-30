package service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import domain.CookBook;
import domain.Recipe;
import rest.ErrorMessages;


@Stateless
public class RecipeService {
	
	@EJB
	private CookBook cookbook;

	public int createRecipe(Recipe recipe) {
		
		if (recipe.getName().length() > 50) {
			throw new AppException(ErrorMessages.name_too_long);
		}
		
		if (recipe.getInstructions().length() > 2000) {
			throw new AppException(ErrorMessages.instructions_too_long);
		}
		
		if (recipe.getIngredients().size() > 20) {
			throw new AppException(ErrorMessages.ingredients_too_long);
		}
		
		Recipe existingRecipe = cookbook.find(recipe.getName());
		
		if (existingRecipe != null) {
			throw new AppException(ErrorMessages.recipe_already_exists);
		}
		
		recipe.setId(cookbook.nextId());
		cookbook.getRecipes().add(recipe);
		
		return recipe.getId();
	}
	
}

