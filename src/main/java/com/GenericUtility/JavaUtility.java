package com.GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will return Random Number
	 * 
	 * @return
	 */
	public int randomNum() {
		Random random = new Random();
		return random.nextInt(1000);

	}

	/**
	 * This Method will return system date
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		return d.toString();

	}

	/**
	 * This Method will return system date in specific format
	 * 
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String day = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String date = day + "-" + month + "-" + year + "-" + time;
		return date;

	}

}
