package response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import domain.Recipe;
import rest.RestResponse;



@XmlRootElement
public class RecipesResponse extends RestResponse {

	private List<Recipe> recipes;
	

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
