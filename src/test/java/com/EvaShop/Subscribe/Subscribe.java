package com.EvaShop.Subscribe;

import com.EvaShop.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Subscribe extends WebDriverSettings {

    @Test
    public void subscribe() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();

        homePage.fillSubscribeField("ira.zozulya22@ukr.net");
        homePage.submitSubscribe();

        Assert.assertTrue(homePage.getCurrentUrl().equals("https://eva.ua/ua/"));
        homePage.close();
    }

    @Test
    public void subscribeFailed() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();

        homePage.fillSubscribeField("ira.zozulya22");
        homePage.submitSubscribe();

        // Негативный тест
        Assert.assertTrue(homePage.getError().equals("Будь ласка, введіть правильну адресу електронної пошти (Приклад: johndoe@domain.com)."));
        homePage.close();
   }

}
