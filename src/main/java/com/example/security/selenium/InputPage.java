package com.example.security.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"workspace-menubar\"]/ul/li[1]")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div/div/section/ul/li[1]/input")
    private WebElement inputSearch;

    public InputPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public Boolean verifyInput() {
        if (inputSearch != null && inputSearch.isDisplayed()) {
            return true;
        } else {
            throw new RuntimeException();
        }
    }

    public void click() {
       searchButton.click();
    }
}
