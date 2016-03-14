package dev.rapid.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageHelper {
	private static final Logger logger = 
			LoggerFactory.getLogger(MessageHelper.class);
	
	private static MessageHelper instance = new MessageHelper();
	private static Properties props;
	
	private MessageHelper() {
		initProperties();
	}
	
	public static MessageHelper getInstance() {
		return instance;
	}
	
	private void initProperties() {
		logger.info("Start initProperties method");
		InputStream input = null;
		String messageFileName = Constants.MESSAGE_FILE_NAME;

		try {
			logger.info("Read properties file: " + messageFileName);
			input = MessageHelper.class.getClassLoader().getResourceAsStream(messageFileName);

			props = new Properties();
			// load a properties file
			props.load(input);
		} catch (Exception e) {
			logger.error("An exception was occurred when read properties file: " + messageFileName, e);
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("Cannot close properties file: " + messageFileName, e);
					e.printStackTrace();
				}
			}
		}
		
		logger.info("Finish initProperties method");
	}
	
	public String getMessage(String key) {
		// get the property value
		String value = props.getProperty(key);
		value = value==null? "" : value.trim();
		if("".equals(value)) {
			logger.error("Not exist key or no value for key: " + key);
		} else {
			logger.info("Value for " + key + " is " + value);
		}
		
		return value;
	}
}
