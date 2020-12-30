/**
 * 
 */
package org.openmrs.module.mohappointment.utils;

import java.text.ParseException;
import java.util.Date;

import org.openmrs.api.context.Context;


/**
 * @author HP
 *
 */
public class DateConversion {

	public static Date convertToDate(String dateString) throws ParseException {
		Date convertedDate = Context.getDateFormat().parse(dateString);
		return convertedDate;

	}

	 public static long daysBetweenDates(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}

	
}
