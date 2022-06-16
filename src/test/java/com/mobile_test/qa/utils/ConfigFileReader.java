package com.mobile_test.qa.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
   
    private static Properties properties;
    private final static String propertyFilePath= "src/test/resources/configs/config.properties";

   
    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }      
    }
   
    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");      
    }
   
    public long getImplicitlyWait() {      
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");      
    }
   
    public static String getApplicationUrl(String adress) throws IOException {
    	properties = new Properties();
		FileInputStream fis = new FileInputStream(propertyFilePath);
		properties.load(fis);
        String url = properties.getProperty(adress);
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    
	public void getParameters(String parameter) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(propertyFilePath);
		prop.load(fis);
	}
   
}
