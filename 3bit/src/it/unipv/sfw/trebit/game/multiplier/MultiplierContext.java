package it.unipv.sfw.trebit.game.multiplier;

public class MultiplierContext {
	private IMultiplierStrategy strategy;
	private static MultiplierContext instance;
	
	
	public static MultiplierContext getInstance() {
		if(instance==null)
			instance= new MultiplierContext();
		
		return instance;
	}
	
	
	private MultiplierContext() {
		

		MultiplierFactory f = new MultiplierFactory();
		strategy=f.getMultiplierStrategy();
	}
	
	public double getMultiplier() {
		if(strategy==null)
			return 1;
		else
			return strategy.getMultiplier();
	}
}
