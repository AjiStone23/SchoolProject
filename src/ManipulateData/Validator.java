/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulateData;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author ajist
 */
public class Validator {

	public static Predicate<String> forLettersOnly = s -> s.trim().matches("[a-z A-Z]{1,15}");
	public static Predicate<String> forLettersAndDigits = s -> s.trim().matches("[a-z A-Z_0-9]{1,15}");
	
	public static Predicate<String> forFloat = s -> s.trim().matches("[0-9]++\\.[0-9]++");
	public static Predicate<String> forPossitiveInt = s -> s.trim().matches("[0-9]++");
	public static Predicate<String> forInt = s -> s.trim().matches("-?[0-9]{1,9}");
	
	public static Predicate<String> forDate = Validator::isValidDateSyntax;

	public static boolean isValid(String s, Predicate<String> p) {
		return p.test(s);

	}

	public static String loopAndGetValidString(Scanner sc, Predicate<String> p) {
		String s = sc.nextLine();

		while (!isValid(s, p)) {

			System.out.println("Invalid input try again !!!");

			s = sc.nextLine();

		}
		return s.trim();

	}

	public static boolean isValidDateSyntax(String s) {
		try {
			LocalDate.parse(s.trim());
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;

	}
	
	
	

	public static int loopAndGetValidInt(Scanner sc, Predicate<Integer> r) {
		int i;

		i = Integer.parseInt(loopAndGetValidString(sc, forInt));

		while (!r.test(i)) {
			System.out.println("Invalid Input try again!");
			i = Integer.parseInt(loopAndGetValidString(sc, forInt));

		}

		return i;

	}

	public static LocalDate loopAndGetValidDate(Scanner sc, Predicate<LocalDate> d) {

		LocalDate date = LocalDate.parse(loopAndGetValidString(sc, forDate));

		while (!d.test(date)) {
			System.out.println("Invalid Input try again!");
			date = LocalDate.parse(loopAndGetValidString(sc, forDate));

		}

		return date;

	}

	public static float loopAndGetValidFloat(Scanner sc, Predicate<Float> f) {

		float fNumber = Float.parseFloat(loopAndGetValidString(sc, forFloat));

		while (!f.test(fNumber)) {
			System.out.println("Invalid Input try again!!");
			fNumber = Float.parseFloat(loopAndGetValidString(sc, forFloat));

		}
		return fNumber;
	}
}
