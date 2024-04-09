package com.sample.test.pages;

import com.sample.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage() {
    }

    @FindBy(how = How.ID, using = "UserName")
    public WebElement lbl_userName;

    @FindBy(how = How.ID, using = "Password")
    public WebElement lbl_password;

    @FindBy(how = How.XPATH, using = "//input[@value='Log in']")
    public WebElement btn_submit;

    public BasePage login(String username, String password) {
        lbl_userName.sendKeys(username);
        lbl_password.sendKeys(password);
        btn_submit.click();
        return getInstance(HomePage.class);
    }
}
