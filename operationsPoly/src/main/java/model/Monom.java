package model;
/**
 * 
 * @author Gombos Kriszta
 * abstract class for the monoms that are part of the polynomial
 *
 */
public abstract class Monom {
	
	
	protected abstract double getCoefficient();
	protected abstract int getGrad();
	protected abstract void setCoefficient(double d);
	protected abstract void setGrad(int i);
		
	
	
}
