package com.mystore.utility;

import org.apache.log4j.Logger;

public class Log {
	
	public static Logger log=Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String testCaseName) {
		log.info("startTestCase: "+testCaseName+ "execution Starts");
	}
	
	public static void endTestCase(String testCaseName) {
		log.info("endTestCase: "+testCaseName+ "execution Ends");
	}
	
	public static void info(String message) {
		log.info(message);
	}
	
	public static void warn(String message) {
		log.warn(message);
	}
	
	public static void debug(String message) {
		log.debug(message);
	}
	
	public static void error(String message) {
		log.error(message);
	}
	
	public static void fatal(String message) {
		log.fatal(message);
	}

}
