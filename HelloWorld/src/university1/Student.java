package university1;

public class Student {
	public String fname;
	public String lname;
	private int math_marks;
	private int physics_marks;
	private int chem_marks;
	
	public Student(String fname,String lname)
	{
		this.fname = fname;
		this.lname = lname;
	}
	
	public void marks(int math,int physics,int chem)
	{
		this.math_marks = math;
		this.physics_marks = physics;
		this.chem_marks = chem;
	}
	
	public float average()
	{
		return (math_marks+physics_marks+chem_marks) / 3;
	}
}
