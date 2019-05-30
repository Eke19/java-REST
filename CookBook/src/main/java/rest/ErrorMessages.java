package rest;



public class ErrorMessages {
	
	private int code;
	private String message;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	private ErrorMessages(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	public static final ErrorMessages ok = new ErrorMessages (0, "Operation successfull!");
	
	public static final ErrorMessages name_too_long = new ErrorMessages (100, "Recipe name must be shorter than 50 characters!");

	public static final ErrorMessages instructions_too_long = new ErrorMessages (101, "Instructions must have less than 2000 characters");

	public static final ErrorMessages ingredients_too_long = new ErrorMessages (102, " Ingredients must have less than 20 characters!");

	public static final ErrorMessages recipe_already_exists = new ErrorMessages (103, "Recipe with that name already exists !");

	
}
