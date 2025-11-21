package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;



import constants.ConstantPaths;
import customException.FrameWorkException;

public final class PropertiesUtil {
	
	private static final Properties property = new Properties();
	
	static void loadPropertiesFile(String filePath) {
		try(FileInputStream file = new FileInputStream(filePath)) {
			property.load(file);
		} catch(IOException e) {
			throw new FrameWorkException("IOException: Unable to Load Properties File");
		}
	}
	
	public static String getPropertyValue(String key) {
		loadPropertiesFile(ConstantPaths.CONFIG_FILE_PATH);
		System.out.println(key + " is: " +property.getProperty(key.toLowerCase()));
		if(Objects.isNull(property.getProperty(key.toLowerCase())) ) {
			throw new FrameWorkException("Property name - " + key + " is not found. Please check the config.properties");
		}
		return property.getProperty(key.toLowerCase());
	}

}
