package dev.rapid.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateFormatUtil {
	static List<String> dateForms = Arrays.asList(new String[] { "d/M/yyyy", "d-M-yyyy", "M/yyyy", "M-yyyy", "yyyy" });

	public static String dateToString(Date date) {
		String result = "";

		SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");
		result = format.format(date);

		return result;
	}

	public static Date stringToDate(String dateString) {
		Date result = null;

		SimpleDateFormat format;
		for (String form : dateForms) {
			format = new SimpleDateFormat(form);
			try {
				result = format.parse(dateString);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static LocalDate stringToLocalDate(String dateString) {
		if (StringUtil.isNullOrEmpty(dateString)) {
			return null;
		}

		return stringToDate(dateString).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static String localDateToString(LocalDate localDate) {
		if (null == localDate) {
			return null;
		}

		String result = "";
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		result = dateToString(date);

		return result;
	}
}
