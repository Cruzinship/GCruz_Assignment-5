/*
 * Class: CMSC203 30339
 * Instructor: Grinberg
 * Description: HolidayBonus class will allocate Bonuses for stores based off their sales
 * Due: 04/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Gianpaulo Cruz
*/

package Project;
public class HolidayBonus{
	
    public static final double HIGHEST_SALES_BONUS = 5000.0;
    public static final double LOWEST_SALES_BONUS = 1000.0;
    public static final double OTHER_STORE_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        double[] highestSalesPerProduct = new double[data[0].length];
        double[] lowestSalesPerProduct = new double[data[0].length];

        for (int j = 0; j < data[0].length; j++) {
            highestSalesPerProduct[j] = TwoDimRaggedArrayUtility.getHighestInColumn(data, j);
            lowestSalesPerProduct[j] = TwoDimRaggedArrayUtility.getLowestInColumn(data, j);
        }

        for (int i = 0; i < data.length; i++) {
            double totalBonus = 0.0;

            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] >= 0) {
                    // Checking incase a value is alone in the column
                    boolean aloneInColumn = true;
                    for (int k = 0; k < data.length; k++) {
                        if (k != i && data[k].length > j && data[k][j] >= 0) {
                            aloneInColumn = false;
                            break;
                        }
                    }
                    if (aloneInColumn) {
                        totalBonus += HIGHEST_SALES_BONUS;
                    } else {
                        if (data[i][j] == highestSalesPerProduct[j] && highestSalesPerProduct[j] != lowestSalesPerProduct[j]) {
                            totalBonus += HIGHEST_SALES_BONUS;
                        } else if (data[i][j] == lowestSalesPerProduct[j] && highestSalesPerProduct[j] != lowestSalesPerProduct[j]) {
                            totalBonus += LOWEST_SALES_BONUS;
                        } else {
                            totalBonus += OTHER_STORE_BONUS;
                        }
                    }
                }
            }

            bonuses[i] = totalBonus;
        }

        return bonuses;
    }


    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0.0;
        double[] storeBonuses = calculateHolidayBonus(data);

        for (double bonus : storeBonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }
    
}