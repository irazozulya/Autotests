package com.EvaShop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Search {

    @Test
    public void tracking() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/irazozulya/Desktop/Autotests/src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://eva.ua/ua/");

        WebElement btn = driver.findElement(By.linkText("Відстеження замовлення"));
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.name("order_number")).sendKeys("");
        driver.findElement(By.xpath("//*[contains(text(), 'Відстежити замовлення')]")).click();
        wait = new WebDriverWait(driver, 10);
        WebElement message = driver.findElement(By.cssSelector("[data-bind=\"html: message.text\"]"));
        boolean bl = message.isDisplayed();
        Assert.assertTrue(bl);

        driver.quit();
    }

    @Test
    public void changeLanguage() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/irazozulya/Desktop/Autotests/src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://eva.ua/ua/");

        driver.findElement(By.cssSelector("[data-base-url=\"https://eva.ua/\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        String str = driver.findElement(By.className("view-default")).getText();
        Assert.assertTrue(str.equals("Рус"));

        driver.quit();
    }

    @Test
    public void searchRumjana() {
        System.setProperty("webdriver.chrome.driver", "/Users/irazozulya/Desktop/Autotests/src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://eva.ua/ua/");

        driver.findElement(By.id("search")).sendKeys("румяна");
        driver.findElement(By.className("autocomplete__search-button")).click();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://eva.ua/ua/299-300-301/rumjana/"));

        driver.quit();
    }
}
