package com.sample.test.pages;

import com.sample.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeListPage extends BasePage {
    public EmployeeListPage() {
    }

    @FindBy(how = How.XPATH ,using = "//a[text()='Create New']")
    public WebElement btn_createNew;



}
