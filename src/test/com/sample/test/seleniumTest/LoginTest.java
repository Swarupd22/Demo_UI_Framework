package com.sample.test.seleniumTest;

import com.sample.framework.base.BrowserType;
import com.sample.framework.base.DriverContext;
import com.sample.framework.base.FrameworkInitialize;
import com.sample.framework.utilities.ExcelUtil;
import com.sample.test.pages.HomePage;
import com.sample.test.pages.LoginPage;
import jxl.read.biff.BiffException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends FrameworkInitialize {

    @BeforeTest
    public void Initialize() throws BiffException, IOException {
        initializeBrowser(BrowserType.Chrome);
        DriverContext.Browser.goToUrl("http://eaapp.somee.com/");
        ExcelUtil util = new ExcelUtil("C:\\Users\\SWARUP\\IdeaProjects\\Demo_Framework\\data.xls");
    }

    @Test
    public void login() throws InterruptedException {
        Thread.sleep(3000);
        CurrentPage  = getInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
        Thread.sleep(3000);
        //CurrentPage.As(LoginPage.class).login("admin","password");
        //DDT from Excel
        CurrentPage.As(LoginPage.class).login(ExcelUtil.ReadCell("UserName",1),ExcelUtil.ReadCell("Password",1));
    }

    @AfterTest
    public void tearDown(){
        DriverContext.Driver.close();
    }
}
