package it.unipv.sfw.trebit.model.game.multiplier;

public class EasterStrategy implements IMultiplierStrategy{
	

	private final double MULTIPLIER=1.5;
	
	public double getMultiplier() {
		return MULTIPLIER;
	}
}
