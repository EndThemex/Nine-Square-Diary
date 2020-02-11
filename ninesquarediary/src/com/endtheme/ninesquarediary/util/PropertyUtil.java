package com.endtheme.ninesquarediary.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.endtheme.ninesquarediary.DiaryConstants;

public class PropertyUtil {

	private static Properties properties = null;

	static {
		InputStream propertyIn = null;
		try {
			propertyIn = PropertyUtil.class.getClassLoader().getResourceAsStream(DiaryConstants.APP_PROPERTIES);
			properties = new Properties();
			properties.load(propertyIn);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (propertyIn != null) {
				try {
					propertyIn.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static String getStaticUrl() {
		return properties.getProperty("static_url");
	}

}
