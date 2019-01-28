package com.mobile.properties;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class LoadProperties {
	private static final String PATH_APP_FILE_NAME = "path_app.properties";

	
	public static String getPathApp(String property) {
		return LoadProperties.get(PATH_APP_FILE_NAME, property);
	}
	
	private static String get(String file, String property) {
		Properties prop = new Properties();
		InputStream fileProperties = null;
		
		try {
			fileProperties = LoadProperties.class.getClassLoader().getResourceAsStream(file);
			prop.load(fileProperties);
			return prop.getProperty(property);
		} catch (Exception e) {
			Logger.getGlobal().severe(e.getMessage() + " - Access file ERROR (property file '" + file + "')");
			e.printStackTrace();
		}
		return "";
	}

}
