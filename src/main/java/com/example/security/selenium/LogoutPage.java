package com.example.security.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"react\"]/div/nav/div/div[2]/ul/li[4]/a")
    private WebElement logoutButton;

    public LogoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void logout() {
        logoutButton.click();
    }
}
