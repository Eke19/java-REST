package domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Recipe {

	private int id;
	private String name;
	private List<String> ingredients = new ArrayList<>();
	private String instructions;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	@Override
	public String toString() {
		return "name : " + name;
	}
	
	public void copyAttributes(Recipe recipe) {
		this.setName(recipe.getName());
		
		this.ingredients.clear();
		this.ingredients.addAll(recipe.getIngredients());
		
		this.setInstructions(recipe.getInstructions());
		
	}
	
}


