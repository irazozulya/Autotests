package com.EvaShop.Subscribe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(className = "page-header")
    private WebElement header;

    @FindBy(xpath = "//*[contains(text(), 'Підписатися')]")
    private WebElement subsBtn;

    @FindBy(name = "email")
    private WebElement subsFld;

    @FindBy(id = "newsletter-error")
    private WebElement subsErr;

    public void open() {
        driver.get("https://eva.ua/ua/");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void fillSubscribeField(String strEmail) {
            subsFld.sendKeys(strEmail);
    }

    public void submitSubscribe() {
        subsBtn.click();
    }

    public String getError() {
        return subsErr.getText();
    }

    public void close() {
        driver.quit();
    }
}