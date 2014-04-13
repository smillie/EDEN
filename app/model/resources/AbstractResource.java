package model.resources;

import com.google.gson.annotations.Expose;

public abstract class AbstractResource implements Resource {

	@Expose private String name;

	@Expose private String description;

	@Expose private int amount;

	
	public AbstractResource(String name, String description, int amount) {
		
		this.name = name;
		this.description = description;
		this.amount = amount;

	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription(){
		return this.description;

	}

	public int getAmount() {
		return this.amount;
	}

}
