package constants;

import java.io.File;

public class ConstantPaths {
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String RESOURCE_PATH = PROJECT_PATH + File.separator +"src/test/resources/";
	public static final String CONFIG_FILE_PATH = PROJECT_PATH + File.separator + "config" + File.separator + "config.properties";

}
