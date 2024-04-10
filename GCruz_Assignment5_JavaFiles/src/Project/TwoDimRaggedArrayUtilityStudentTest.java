/* 

 * Class: CMSC203 30339 
 * Instructor: Grinberg 
 * Description: Test TwoDimRaggedArraysUtility mehtods
 * Due: 04/15/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source.  
 * I have not given my code to any student. 
 *  Print your Name here: Gianpaulo Cruz 
 */ 
package Project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TwoDimRaggedArrayUtilityStudentTest {

    @Test
    public void testGetTotal() {
        double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        assertEquals(36.0, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
    }

    @Test
    public void testGetAverage() {
        double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        assertEquals(4.0, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), 0.001);
        assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 1), 0.001);
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 2), 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInArray(data), 0.001);
    }

    @Test
    public void testGetHighestInColumn() {
        double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 1), 0.001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 2), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
    }

    @Test
    public void testGetLowestInColumn() {
        double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 0), 0.001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 2), 0.001);
    }

    @Test
    public void testReadFile() {
        try {
            File file = new File("dataSet1.txt");
            double[][] data = TwoDimRaggedArrayUtility.readFile(file);
            assertEquals(1.0, data[0][0], 0.001);
            assertEquals(2.0, data[0][1], 0.001);
            assertEquals(3.0, data[1][0], 0.001);
            assertEquals(4.0, data[1][1], 0.001);
            assertEquals(5.0, data[1][2], 0.001);
            assertEquals(6.0, data[2][0], 0.001);
            assertEquals(7.0, data[2][1], 0.001);
            assertEquals(8.0, data[2][2], 0.001);
        } catch (FileNotFoundException e) {
            fail("File not found.");
        }
    }

    @Test
    public void testWriteToFile() {
        try {
            File inputFile = new File("dataSet1.txt");
            double[][] data = { { 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
            TwoDimRaggedArrayUtility.writeToFile(data, inputFile);

            File outputFile = new File("dataSet1.txt");
            double[][] outputData = TwoDimRaggedArrayUtility.readFile(outputFile);

            assertEquals(data.length, outputData.length);
            for (int i = 0; i < data.length; i++) {
                assertEquals(data[i].length, outputData[i].length);
                for (int j = 0; j < data[i].length; j++) {
                    assertEquals(data[i][j], outputData[i][j], 0.001);
                }
            }
        } catch (FileNotFoundException e) {
            fail("File not found.");
        }
    }
}