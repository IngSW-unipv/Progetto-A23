package it.unipv.sfw.trebit.game.multiplier;

public class NewYearStrategy implements IMultiplierStrategy{
	

	private final double MULTIPLIER=2.5;
	
	public double getMultiplier() {
		return MULTIPLIER;
	}
}
