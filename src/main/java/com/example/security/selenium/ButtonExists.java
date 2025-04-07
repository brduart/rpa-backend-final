package com.example.security.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ButtonExists {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"context_login\"]/section[4]/input[7]")
    private WebElement loginButton;

    public ButtonExists(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public Boolean verifyButton() {
        if (loginButton != null && loginButton.isDisplayed()) {
           return true;
        } else {
            throw new RuntimeException();
        }
    }
}
