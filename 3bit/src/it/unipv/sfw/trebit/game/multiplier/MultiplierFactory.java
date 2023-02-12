package it.unipv.sfw.trebit.game.multiplier;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;


public class MultiplierFactory {
	
	private IMultiplierStrategy multiplier;
	private final String PROPERTYNAME="multiplier.strategy.class.name";
	
	
	public IMultiplierStrategy getMultiplierStrategy() {
		if(multiplier==null) {
			
			Properties p=new Properties(System.getProperties());
			String MultiplierClassName;
			
			try {
				p.load(new FileInputStream("properties/properties"));
				MultiplierClassName=p.getProperty(PROPERTYNAME);
				
				Constructor c = Class.forName(MultiplierClassName).getConstructor();
				multiplier=(IMultiplierStrategy)c.newInstance();
			
			}
			catch(Exception e) {
				e.printStackTrace();
				multiplier=null;
			}
		}
		
		return multiplier;
		
	}
}
