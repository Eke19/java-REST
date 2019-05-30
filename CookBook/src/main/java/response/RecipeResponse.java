package response;

import javax.xml.bind.annotation.XmlRootElement;

import domain.Recipe;
import rest.RestResponse;


@XmlRootElement
public class RecipeResponse extends RestResponse {

	private Recipe recipe;
	
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public Recipe getRecipe() {
		return recipe;
	}
}