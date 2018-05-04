package cn;

public class ComplexNumber {
	private double realpart;
	private double imaginarypart;
	
	public ComplexNumber(double r, double i)
	{
		realpart = r;
		imaginarypart = i;
	}
	
	public String toString()
	{
		return realpart+" + "+imaginarypart+"i";
	}
	
	public ComplexNumber addTwoComplexNumber(ComplexNumber n2)
	{
		double resultrealpart = n2.realpart + this.realpart;
		double resultimaginarypart = n2.imaginarypart + this.imaginarypart;
		ComplexNumber n3 = new ComplexNumber(resultrealpart,resultimaginarypart); 
		return n3;
	}
}
