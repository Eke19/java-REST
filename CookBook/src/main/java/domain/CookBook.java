package domain;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;



@Singleton
@Startup
public class CookBook {
	
	private static int id = 0;

	private List<Recipe> recipes = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		
		Recipe recipe = new Recipe();
		int id = nextId();
		recipe.setId(id);
		recipe.setName("Recept " + id);
		recipe.setInstructions("Priprema " + id);
		
		recipes.add(recipe);
		
		recipe = new Recipe();
		id = nextId();
		recipe.setId(id);
		recipe.setName("Recept " + id);
		recipe.setInstructions("Priprema " + id);
		
		recipes.add(recipe);
		
		recipe = new Recipe();
		id = nextId();
		recipe.setId(id);
		recipe.setName("Recept " + id);
		recipe.setInstructions("Priprema " + id);
		
		recipes.add(recipe);
	}
	
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	public static int nextId() {
		return ++id;
	}
	
	public Recipe find(int id) {

		for (Recipe r : getRecipes()) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}
	
	public Recipe find(String name) {

		for (Recipe r : getRecipes()) {
			if (r.getName().equals(name)) {
				return r;
			}
		}
		return null;
	}
	
	public Recipe find(int id, String name) {

		for (Recipe r : getRecipes()) {
			if (r.getId() == id && r.getName().equals(name)) {
				return r;
			}
		}
		return null;
	}
	
}

