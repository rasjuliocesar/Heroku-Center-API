package com.herokuCenterApi.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {

	public int calculateAge(Date birth) {	
		Calendar dateOfBirth = new GregorianCalendar();
		Calendar today = Calendar.getInstance();
		
		dateOfBirth.setTime(birth);
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);
		
		if (today.before(dateOfBirth)) {
			age--;
		}
				
		return age;
	}
}
