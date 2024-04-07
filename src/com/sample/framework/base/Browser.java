package com.sample.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver Driver;
    public Browser(WebDriver driver) {
        Driver = driver;
    }
    public BrowserType Type;
    public void goToUrl(String url){
        Driver.get(url);
    }
}

