package model.components;

public abstract class AbstractGrowingBay extends AbstractComponent {

	public AbstractGrowingBay(String name, String description, int maxHealth) {
		super(name, description, maxHealth);
	}

	protected int getPerformancePercentage () {
		
		float lightlevel = super.getEnvironment().getLightLevel();
		int integrity = (int) (Math.floor(super.getCurrentHealth()*1.0)/(super.getMaxHealth()*1.0));
		
		int performance = (int) (lightlevel * integrity);
		
		return performance;
		
	}
}
