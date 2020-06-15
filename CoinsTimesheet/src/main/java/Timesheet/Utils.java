package Timesheet;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;



public class Utils {
	public static String getGlobalValue(String key) throws IOException {
		// Method to fetch global property
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}

	}


