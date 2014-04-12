package resources;

import com.google.gson.annotations.Expose;

public abstract class AbstractResource implements Resource {

	@Expose private String name;

	@Expose private String description;

	@Expose private int ammount;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(int ammount) {
		this.ammount = ammount;
	}

	public String getDescription(){
		return this.description;

	}

	public int getAmount() {
		return this.ammount;
	}

}
