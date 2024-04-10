/*
 * Class: CMSC203 30339
 * Instructor: Grinberg
 * Description: Testing HolidayBonus Class Methods
 * Due: 04/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Gianpaulo Cruz
*/

package Project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent {
    private double[][] dataSet2 = { { 10000.0, 20000.0 }, { 5000.0, 10000.0 }, { 15000.0, 25000.0 } };

    @Test
    public void testCalculateHolidayBonus() {
        try {
            double[] result = HolidayBonus.calculateHolidayBonus(dataSet2);
            assertEquals(4000.0, result[0], 0.001);
            assertEquals(2000.0, result[1], 0.001);
            assertEquals(10000.0, result[2], 0.001);
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        assertEquals(16000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), 0.001);
    }
}