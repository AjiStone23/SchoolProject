/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ajist
 */
public class UtilRdmGen {
	
	
	
	public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear,int startMonth,int endMonth) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(startMonth,endMonth);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
	
	
	public static <T> T getRandomElement(List<T> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
}
