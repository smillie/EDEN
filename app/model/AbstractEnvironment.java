package model;

public abstract class AbstractEnvironment implements Environment {

	private String name;
	private String description;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String getDescription() {
		return description;
	}

}
