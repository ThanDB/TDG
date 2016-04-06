package dev.rapid.util;

public class StringUtil {
	public static boolean isNullOrEmpty(String text) {
		if(text == null) {
			return true;
		}

		if("".equals(text.trim())) {
			return true;
		}

		return false;
	}
}
