package com.selenquery.core;

public class Assertion {

	public static boolean test(boolean expected, boolean condition) {
		return test(expected, condition, "");
	}

	public static boolean test(boolean expected, String val1, String val2, String customMessage) {
		if (!test(expected, val1.equals(val2), customMessage)) {
			printDetails(expected,val1, val2);
			return false; 
		}
		return true;
	}

	public static boolean test(boolean expected, int val1, int val2, String customMessage) {
		if (!test(expected, val1 == val2, customMessage)) {
			printDetails(expected,val1, val2);
			return false; 
		}
		return true;
	}

	public static boolean test(boolean expected, long val1, long val2, String customMessage) {
		if (!test(expected, val1 == val2, customMessage)) {
			printDetails(expected,val1, val2);
			return false; 
		}
		return true;
	}

	public static boolean test(boolean expected, Object val1, Object val2, String customMessage) {
		if (!test(expected, val1 == val2, customMessage)) {
			printDetails(expected,val1, val2);
			return false; 
		}
		return true;
	}

	static void printDetails(boolean expected, Object expectedVal, Object actualVal) {
		if (expected) {
			System.err.println("Expected Value : " + expectedVal);
		} else {
			System.err.println("Expected Value Should Not : " + expectedVal);
		}
		System.err.println("Actual Value   : " + actualVal);
		sleep(100);
		throw new RuntimeException("Assertion Failed");
	}

	public static boolean test(boolean expected, boolean condition, String customMessage) {
		if (condition == expected) {
			Log.info("Assertion Passed > " + customMessage);
			return true;
		} else {
			if (customMessage == "") {
				if(expected){
					System.err.print("Assertion Failed > Should But it is not > ");
				}else {
					System.err.print("Assertion Failed > ShouldNot But it is > ");	
				}
				
				
			} else {
				if(expected){
					System.err.println("Assertion Failed > Should > " + customMessage + " > But it is not.");
				}else {
					System.err.println("Assertion Failed > ShouldNot > " + customMessage + " > But it is.");	
				}
				
			}
			sleep(100);
			return false;
		}
	}

	private static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
