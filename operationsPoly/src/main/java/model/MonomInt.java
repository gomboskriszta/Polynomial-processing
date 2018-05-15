package model;

public class MonomInt extends Monom{

	private int grad;
	private int coefficient;
	
	public MonomInt(int coefficient, int grad)
	{
		this.grad = grad;
		this.coefficient = coefficient;
	}
	
	
	protected double getCoefficient() {
		return (int)coefficient;
	}
	
	public int getGrad() {
		return grad;
	}

	protected void setCoefficient(double x)
	{
		coefficient = (int)x;
	}
	
	public void setGrad(int x) {
		grad = x;
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

