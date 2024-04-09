package com.sample.framework.config;

import com.sample.framework.base.BrowserType;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void populateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.readProperty();
    }

    private void readProperty() throws IOException {
        //Create Property Object
        Properties property = new Properties();
        //Load the Property file available in same package
        property.load(getClass().getResourceAsStream("GlobalConfig.properties"));
        //Get AUTConnection String
        Settings.AUTConnectionString = property.getProperty("AUTConnectionString");
        //Get Reporting String
        Settings.ReportingConnectionString = property.getProperty("ReportingConnectionString");
        //Get LogPath
        Settings.LogPath = property.getProperty("LogPath");
        //Get DriverType
        Settings.DriverType = property.getProperty("DriverType");
        //GEt ExcelSheetPath
        Settings.ExcelSheetPath = property.getProperty("ExcelSheetPath");
        //Get AUT
        Settings.AUT = property.getProperty("AUT");
        //Browser Type
        Settings.BrowserType = BrowserType.valueOf(property.getProperty("BrowserType"));
    }
}
