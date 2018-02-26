import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Counter {
	private ArrayList<String> TotalDataSetString = new ArrayList<String>();
	private ArrayList<String> timesString = new ArrayList<String>();
	Double[] TotalValuesArray;
	Double[] timeVals;
	private boolean debugger = false;
	Counter(String fileName)
	{

		Scanner scan = null; 
		try 
		{
			scan = new Scanner (new File (fileName));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}


		while (scan.hasNext()) 
		{
			String TempVal = "";
			String[] valuesArray = null;
			TempVal = scan.next();
			String temp;
			valuesArray = TempVal.split(",");
			for (int count = 0; count < valuesArray.length; count++) {
				temp = valuesArray[1];
				timesString.add(temp);
				temp = valuesArray[4];
				TotalDataSetString.add(temp);

			}

		}
		scan.close();
	}
	private Double[] ToDouble() //changes all strings to doubles
	{
		ArrayList<Double> TotalDataSet = new ArrayList<Double>();
		ArrayList<Double> times = new ArrayList<Double>();
		for (int z = 0; z <= 4; z++)
		{
			TotalDataSetString.remove(0);
			timesString.remove(0);
		}
		String holderString;
		double holderDouble;
		for(int j = 0; j < TotalDataSetString.size(); j+=5) {
			holderString = TotalDataSetString.get(j);
			if(holderString.indexOf("-") == -1) {
				holderDouble = Double.parseDouble(holderString);

				TotalDataSet.add(holderDouble);
				holderString = timesString.get(j);

				holderDouble = Double.parseDouble(holderString);

				times.add(holderDouble);
			}
		}
		TotalValuesArray = TotalDataSet.toArray(new Double[0]);
		timeVals = times.toArray(new Double[0]);

		return TotalValuesArray;
	}
	public int DataAnalyzer(double rangeStart){ //analyzes all data and counts steps based on data
		int steps = 0;
		int debugStepHolder = 0;
		ToDouble();
		double prevVal = 0.00;
		double currVal = 0.00;
		int adder = 80;
		int valueCounter = 0;
		int prevSteps = 0;
		for (int k = 0; k < TotalValuesArray.length; k++) {
			prevVal = currVal;
			prevSteps = steps;
			currVal = TotalValuesArray[k];
			if (debugger == true) {
				System.out.println(currVal + ":" + prevVal);
			}

			if(currVal > prevVal && currVal >= .98 || prevVal == currVal  && currVal > .98) {
				if (currVal > rangeStart) {
					steps++;


					k = k + adder;// best skip value = 80

				}
			}
			if(debugger == true)
			{
			if(prevSteps != steps) {
				valueCounter = 0;
			}
			valueCounter++;
		}
		}
		if (debugger == true) {
			debugStepHolder += steps/2;
			System.out.println("Skipped: " + adder + " values, steps now equals: " + steps + "/ Flagger Value = " + rangeStart);
			steps = 0;
		}
		else { 
			debugStepHolder = steps;
		}
	
		return debugStepHolder;
	}

}