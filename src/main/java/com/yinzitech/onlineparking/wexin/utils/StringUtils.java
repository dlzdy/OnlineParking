package com.yinzitech.onlineparking.wexin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static boolean isNull(String str) {
		return (str == null || str.equals(""));
	}

	public static boolean isNullArray(String... strs) {
		if (strs == null || strs.length <= 0) {
			return true;
		} else {
			for (String str : strs) {
				if (isNull(str)) {
					return true;
				}
			}
			return false;
		}
	}

	public static double string2Double(String string) {
		if (isNumber(string)) {
			return Double.parseDouble(string);
		}
		return 0d;
	}

	public static boolean isNull(int[] str) {
		return (str == null || str.length == 0);
	}

	public static boolean isNull(Long[] str) {
		return (str == null || str.length == 0);
	}

	public static boolean isNull(long[] str) {
		return (str == null || str.length == 0);
	}

	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	public static boolean isNumber(String str) {
		if (isNotNull(str)) {
			try {
				Double.parseDouble(str);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	public static boolean isNull(String[] str) {
		return (str == null || str.length <= 0);
	}

	public static boolean isNotNull(String[] str) {
		return !isNull(str);
	}

	public static boolean isPhone(String mobile) {
		if (isNotNull(mobile)) {
			if (mobile.length() == 11) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEmail(String email) {
		if (isNotNull(email)) {
			Pattern p = Pattern
					.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
			Matcher m = p.matcher(email);
			return m.matches();
		}
		return false;
	}

}
