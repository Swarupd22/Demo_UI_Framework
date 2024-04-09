package com.sample.test.pages;

import com.sample.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    public HomePage() {
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Login']")
    public WebElement btn_login;

    @FindBy(how = How.XPATH, using = "//a[text()='Employee List']")
    public WebElement btn_employeeList;

    public LoginPage clickLogin() {
        btn_login.click();
        return getInstance(LoginPage.class);
    }

    public void clickEmployeeList() {
        btn_employeeList.click();
    }
}
