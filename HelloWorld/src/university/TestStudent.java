package university;

import university1.Student;

public class TestStudent {

	public static void main(String[] args) {
		Student priyank = new Student("Priyank","Shah");
		Student paula = new Student("Paula","Hernandeze");
		priyank.marks(80,80,80);
		paula.marks(70,70,70);
		System.out.println(priyank.fname+" "+priyank.lname+" : "+priyank.average());
		System.out.println(paula.fname+" "+paula.lname+" : "+paula.average());
	}

}
