
public class Student {

	float GPA;
	int SAT;
	int mathSAT, verbSAT;
	
	public void setGPA(float GPA) {
		this.GPA = GPA;
	}
	
	public float getGPA() {
		return GPA;
	}
	
	public void setSAT(int SAT) {
		this.SAT = SAT;
	}
	
	public int getSAT(){
		return SAT;
	}

	public void printData() {
		System.out.println("GPA: " + this.getGPA() + "  SAT: " + this.getSAT());
		
	}
	
	public void setMathSAT(int mathSAT) {
		this.mathSAT = mathSAT;
	}
	
	public int getMathSAT() {
		return mathSAT;
	}
	
	public void setVerbSAT(int verbSAT) {
		this.verbSAT = verbSAT;
	}
	
	public int getVerbSAT(int verbSAT) {
		return verbSAT;
	}
	
}
