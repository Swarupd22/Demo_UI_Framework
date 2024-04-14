package com.sample.test.seleniumTest;

import com.sample.framework.base.DriverContext;
import com.sample.framework.base.FrameworkInitialize;
import com.sample.framework.config.ConfigReader;
import com.sample.framework.config.Settings;
import com.sample.framework.utilities.*;
import com.sample.test.pages.HomePage;
import com.sample.test.pages.LoginPage;
import org.testng.annotations.*;

public class LoginTest extends FrameworkInitialize {
    @BeforeTest
    public void Initialize() throws Exception {
        ConfigReader.populateSettings();
//        Connection conn = DatabaseUtil.open(Settings.AUTConnectionString);
//        DatabaseUtil.executeQuery("SELECT * FROM Employees", conn);
//        Connection reportConn = DatabaseUtil.open(Settings.ReportingConnectionString);
//        ReportingUtil.CreateTestCycle(reportConn);

        LogUtil log = new LogUtil();
        log.createLogFile();
        log.write("+++++Browser Initialized+++++");
        initializeBrowser(Settings.BrowserType);
        DriverContext.Browser.goToUrl(Settings.AUT);
        ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);
    }

    @BeforeMethod
    public void recordingStart() throws Exception {
        MyScreenRecorderUtil.startRecording("login");
    }

    @Test
    public void login() throws InterruptedException {
        Thread.sleep(3000);
        CurrentPage = getInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
        Thread.sleep(3000);
        CurrentPage.As(LoginPage.class).login(ExcelUtil.ReadCell("UserName", 1), ExcelUtil.ReadCell("Password", 1));
    }

    @AfterMethod
    public void recordingStop() throws Exception {
        MyScreenRecorderUtil.stopRecording();
    }
    @AfterTest
    public void tearDown() {
        DriverContext.Driver.close();
    }
}
