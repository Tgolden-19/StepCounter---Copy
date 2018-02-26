import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class StepMain {
	// TODO Auto-generated method stub
	public static void main(String[] args) {

		Counter data = new Counter("StepsUp57.csv");
		Counter data2 = new Counter("StepsDown58.csv");
		Counter data3 = new Counter("50andsteps61andchest50.csv");
		double r = 1.36;// Best step identifier = 1.35-1.36
		System.out.println(r+" "+data.DataAnalyzer(r) + " Steps up 57");
		System.out.println(r+" "+data2.DataAnalyzer(r) + " Steps down 58");
		System.out.println(r+" "+data3.DataAnalyzer(r) + " Steps 161");

	}
}
