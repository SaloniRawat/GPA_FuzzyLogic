

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreList {

	

	List<Student> studentList = new ArrayList<>();
	
	public void initialise() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner Scan = new Scanner(new File("./src/SAT_GPA.csv"));
		Scanner timeScan = null;

		int index = 0;

		while (Scan.hasNextLine()) {
			timeScan = new Scanner(Scan.nextLine());
			timeScan.useDelimiter(",");
			Student student = new Student();

			while (timeScan.hasNext()) {

				String data = timeScan.next();
				//System.out.println("Index: " + data);
				if (index < 4) {
					index++;
					continue;
				}else if (index % 4 == 0) {
					// assign custno
					student.setMathSAT(Integer.parseInt(data));
					index++;
				} else if (index % 4 == 1) {
					// assign revenue
					student.setVerbSAT(Integer.parseInt(data));
					index++;
				} else if (index % 4 == 2) {
					// assign GPA
					//System.out.println(Float.parseFloat(data));
					student.setGPA(Float.parseFloat(data));
					index++;
				} else if (index % 4 == 3) {
					//assign SAT
					student.setSAT(Integer.parseInt(data));
					index++;
				}
			}

			//student.printData();
			studentList.add(student);
		}

		/*for (int i=0; i< studentList.size(); i++) {
			Student cust = studentList.get(i);
			cust.printData();
		
		}*/
	}
	
	public List<Student> returnStudentList(){
		try {
			initialise();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error reading the file");
		}
		return studentList;
	}
}