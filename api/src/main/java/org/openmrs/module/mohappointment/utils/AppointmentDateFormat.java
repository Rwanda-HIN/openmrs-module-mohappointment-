/**
 * 
 */
package org.openmrs.module.mohappointment.utils;

import java.sql.Time;
import java.text.ParseException;


/**
 * @author HP
 *
 */
public class AppointmentDateFormat {

	public static void main(String[] args) throws ParseException {
		String t="7:59";
		
		Time time = Time.valueOf(t.concat(":00"));
	
		System.out.println(time);

	}

}
