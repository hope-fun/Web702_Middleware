/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * ClassName: SysProperties
 *
 * @description
 * @author nikm
 * @Date 2013-3-7
 *
 */
public class LanguageProperties {

	private static Logger log = Logger.getLogger(LanguageProperties.class);

	/** Singleton local property instance **/
	private static Properties SysLocalPropObject = null;

	/** Property file default **/
	private static String defaultPropFileName = "/language.properties";

	protected long lastModifiedData = -1;
	
	private static  LanguageProperties instance;
	public static LanguageProperties getInstance(){
		 if(instance == null){
			 instance = new LanguageProperties();
		 }
		 return instance;
	}
	
	/** Private Constructor for Singleton Instance */
	private LanguageProperties() {
		SysLocalPropObject = new Properties();
		String tempPath = this.getClass().getResource(defaultPropFileName).getFile();
		File tempFile = new File(tempPath);
		final String filePath;
		if(tempFile.exists()) {
			filePath = tempPath;
		} else {
			filePath = "language.properties";
		}
		
		final LanguageProperties self = this;
		File propertyFile = new File(filePath);
		if (propertyFile.exists()) reloadFile(propertyFile);

		// Loop to detect file changes
		Thread t = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					
					try {
						//log.info("Load property file: " + filePath);
						File propertyFile = new File(filePath);
						if (self.lastModifiedData != propertyFile.lastModified()) {
							log.info("Property file is changed to reload!");
							self.reloadFile(propertyFile);
							self.lastModifiedData = propertyFile.lastModified();
						}
					} catch (Exception e) {

					}
				}
			}
		};
		t.start();
	}

	protected void reloadFile(File propertyFile) {
		FileInputStream inputStreamLocal = null;
		try {
			inputStreamLocal = new FileInputStream(propertyFile);
			SysLocalPropObject.load(inputStreamLocal);
		} catch (Exception e) {
			if (e instanceof FileNotFoundException) {
				log.info("No Local Properties File Found");
				SysLocalPropObject = null;
			} else {
				e.printStackTrace();
			}
		} finally {
			try {
				if (inputStreamLocal != null)
					inputStreamLocal.close();
			} catch (IOException e) {
				log.info("Exception is happened when to close file stream");
			}
		}
	}


	/**
	 * Get a property from the Properties file (uppercase Get to avoid conflict)
	 */
	public String getProperty(String property) {
		String val = null;

		if (SysLocalPropObject != null)
			val = SysLocalPropObject.getProperty(property);

		return (val);

	}

	/** Get a property, allowing for a default value specification */
	public String getProperty(String property, String defaultValue) {
		String val = null;

		if (SysLocalPropObject != null) {
			val = SysLocalPropObject.getProperty(property, defaultValue);
		} else {
			val = defaultValue;
		}

		return (val);
	}

	/**
	 * Get a property from the Properties file (uppercase Get to avoid conflict)
	 */
	public Integer getIntProperty(String property) {
		String val = getProperty(property);
		Integer nVal = null;
		if (val != null) {
			try {
				nVal = Integer.parseInt(val);
			} catch (Exception e) {
	
			}
		}
		return nVal;

	} // getProperty()

	/** Get a property, allowing for a default value specification */
	public Integer getIntProperty(String property, Integer defaultValue) {
		Integer val = getIntProperty(property);

		if (val == null) {
			val = defaultValue;
		}

		return (val);
	}

	/**
	 * Get a property from the Properties file (uppercase Get to avoid conflict)
	 */
	public Long getLongProperty(String property) {
		String val = getProperty(property);
		Long nVal = null;
		try {
			nVal = Long.parseLong(val);
		} catch (Exception e) {

		}
		return nVal;

	}

	/** Get a property, allowing for a default value specification */
	public Long getLongProperty(String property, Long defaultValue) {
		Long val = getLongProperty(property);

		if (val == null) {
			val = defaultValue;
		}

		return (val);
	}

	public boolean getBooleanProperty(String property, boolean defaultValue) {
		boolean retval = false;
		String val = getProperty(property);

		if (val == null || val.equals(""))
			retval = defaultValue;
		else if (val.trim().equalsIgnoreCase("true") || val.trim().equals("1"))
			retval = true;

		return (retval);
	}
	
	/**
	 * Get a property from the Properties file (uppercase Get to avoid conflict)
	 */
	public Double getDoubleProperty(String property) {
		String val = getProperty(property);
		Double nVal = null;
		try {
			nVal = Double.parseDouble(val);
		} catch (Exception e) {

		}
		return nVal;
	} // getProperty()

	/** Get a property, allowing for a default value specification */
	public Double getDoubleProperty(String property, Double defaultValue) {
		Double val = getDoubleProperty(property);

		if (val == null) {
			val = defaultValue;
		}

		return (val);
	}
}
