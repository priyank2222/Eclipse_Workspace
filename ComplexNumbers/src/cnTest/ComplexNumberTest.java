package cnTest;

import cn.ComplexNumber;

public class ComplexNumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumber n1 = new ComplexNumber(6,7);
		ComplexNumber n2 = new ComplexNumber(8,3);
		
		ComplexNumber n3 = n1.addTwoComplexNumber(n2);
		
		System.out.println(n3.toString());
		
		
	}

}
