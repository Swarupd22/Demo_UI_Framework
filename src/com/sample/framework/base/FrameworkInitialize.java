package com.sample.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base {

    WebDriver driver = null;

    public void initializeBrowser(BrowserType browserType) {
        switch (browserType) {
            case Chrome: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            }
            case Firefox: {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            }
            case IE: {
                break;
            }
            case Safari: {

            }
        }
        //Set the browser
        DriverContext.setDriver(driver);
        //browser
        DriverContext.Browser = new Browser((driver));
    }


}
