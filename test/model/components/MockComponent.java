package model.components;

	/**
	 * @author Jamie Stevenson
	 * @date 2014/4/12
	 * This is solely to test the non-abstract methods in
	 * AbstractComponent
	 *
	 */

public class MockComponent extends AbstractComponent {

	public MockComponent (String name, String description, int healthMax) {
		
		super(name, description, healthMax);
	
	}
	
	
	public MockComponent () {
		super ("mock", "description", 0);
	}



}
