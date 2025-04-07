package com.example.security.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class PageTile {
    private WebDriver webDriver;

    public PageTile(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public Boolean verifyPageTitle() {
        if (Objects.equals(webDriver.getTitle(), "Central de Autenticação MV")) {
            return true;
        }
        else {
            throw new RuntimeException();
        }
    }
}
