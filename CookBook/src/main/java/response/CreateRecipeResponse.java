package response;

import javax.xml.bind.annotation.XmlRootElement;


import rest.RestResponse;

@XmlRootElement
public class CreateRecipeResponse extends RestResponse {

	private int id;
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}