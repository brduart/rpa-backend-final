package com.example.security.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private WebDriver webDriver;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "companies")
    private WebElement select;

    @FindBy(xpath = "//*[@id=\"context_login\"]/section[4]/input[7]")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void selectOption() {
        Select roleSelect = new Select(select);
        roleSelect.selectByIndex(2);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
