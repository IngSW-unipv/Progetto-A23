package it.unipv.sfw.trebit.game.multiplier;

public class MultiplierContext {
	private IMultiplierStrategy strategy;
	
	
	public MultiplierContext() {
		
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
