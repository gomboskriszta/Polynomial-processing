package model;

public class MonomReal extends Monom{
	
	
	protected int grad;
	protected double coefficient;

	

	public MonomReal(double coefficient, int grad) {
		this.coefficient = coefficient;
		this.grad = grad;
	}
	

	protected int getGrad() {
		return (int)grad;
	}


	protected void setCoefficient(double coeff) {
		this.coefficient = coeff;
		
	}



	protected double getCoefficient() {
	
		return this.coefficient;
	}
	
	
	protected void setGrad(int grad) {
		this.grad = grad;
		
	}
	


	
	public String toString()
	{
		String str = "";
		if(grad == 0)
		{
			
				str+=coefficient;
			
		}
		else if(coefficient<0)
		{
			str+= coefficient+"x^"+grad;
		}
		else
			str = str+coefficient+"x^"+grad;
		
		return str;
	
	}


	
	

}
