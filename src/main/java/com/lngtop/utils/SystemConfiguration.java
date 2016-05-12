package com.lngtop.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class SystemConfiguration {

	private SystemConfiguration() {
		super();
	}
	
	/**
	 *  获取一个配置文件的配置对象。
	 * @param filename
	 * @return
	 */
	public static Configuration createConfiguration(String filename){
		Configuration config = null;
		try {
			config = new PropertiesConfiguration(filename);
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
		return config;
	}
	
}
