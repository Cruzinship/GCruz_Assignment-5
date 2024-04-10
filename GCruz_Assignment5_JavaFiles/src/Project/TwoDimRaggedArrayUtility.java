/*
 * Class: CMSC203 30339
 * Instructor: Grinberg
 * Description: TwoDimRaggedArrayUtility class will have mutliple methods which aid the GUI and HolidayBonus class.
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Gianpaulo Cruz
*/
package Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TwoDimRaggedArrayUtility extends Object {
	
	public TwoDimRaggedArrayUtility() {
		
	}
	
	public static double getTotal(double[][] data){
		double total = 0;
		
		for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }

        return total;
    }
	
	public static double getAverage(double[][] data){
		double average;
		double total = 0;
		int counter = 1;
		
		for (int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				total += data[i][j];
				counter++;
			}
		}
		if(counter == 0) {
			return 0;
		}else{
			average = total / counter;
			return average;
		}
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		
		for (int i = 0; i < data.length; i++) {
			if(col < data[i].length) {
				total += data[i][col];
			}
		}
		
		return total;
	}
	
	public static double getHighestInArray(double[][] data) {
		double highest = Double.NEGATIVE_INFINITY;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		return highest;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		double highestNum = Double.NEGATIVE_INFINITY;
		
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length) {
				if(data[i][col] > highestNum) {
					highestNum = data[i][col];
				}
			}
		}
		
		return highestNum;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int highestIndex = -1;
		double highest = Double.NEGATIVE_INFINITY;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i][col] > highest) {
				highest = data[i][col];
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double highestNum = data[row][0];
		
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] > highestNum) {
				highestNum = data[row][i];
			}
		}
		return highestNum;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		int highestIndex = 0;
		double highestNum = data[row][0];
		
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] > highestNum) {
				highestNum = data[row][i];
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	
	public static double getLowestInArray(double[][] data) {
		double lowest = Double.POSITIVE_INFINITY;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.POSITIVE_INFINITY; 

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
		    	if (data[i][col] < lowest) {
		    		lowest = data[i][col]; 
		    	}
			}
		}
		return lowest;
	}
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int lowestIndex = -1;
		double lowest = Double.POSITIVE_INFINITY;

		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length) {
				if(data[i][col] < lowest) {
					lowest = data[i][col];
					lowestIndex = i;
				}
			}
		}
		return lowestIndex;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = Double.POSITIVE_INFINITY; 

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i]; 
	        	}
	       	}
		
	        return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
        int lowestIndex = -1; 
        double lowest = Double.POSITIVE_INFINITY; 


        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i]; 
                lowestIndex = i; 
            }
        }

        return lowestIndex;
    }
	
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
	    for (double value : data[row]) {
	        total += value;
	    }
	    return total;
	}
	 
	public static double[][] readFile(File file) throws FileNotFoundException {
	    List<double[]> dataList = new ArrayList<>();

	    try (Scanner scanner = new Scanner(file)) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] tokens = line.split(" ");

	            double[] row = new double[tokens.length];
	            for (int i = 0; i < tokens.length; i++) {
	                row[i] = Double.parseDouble(tokens[i]);
	            }

	            dataList.add(row);
	        }
	    }

	    double[][] dataArray = new double[dataList.size()][];
	    for (int i = 0; i < dataList.size(); i++) {
	        dataArray[i] = dataList.get(i);
	    }

	    return dataArray;
	}

    
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (double[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    writer.print(row[i]);
                    if (i < row.length - 1) {
                        writer.print(" ");
                    }
                }
                writer.println();
            }
        }
    }
}
