package com.dagcan.smokeTest;

import com.dagcan.utilities.ConfigReader;
import com.dagcan.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeTest {
    WebElement userNameText, userPasswordText, submitButton, errorMessage, errorMessage2;
    String errorMesageText;
    @BeforeMethod
    public void setUp2() {
        Driver.getDriver().get(ConfigReader.getProperty("itCareerCenter"));

        WebElement mainPageLoginButton = Driver.getDriver().findElement(By.linkText("MY ACCOUNT"));
        mainPageLoginButton.click();
        userNameText = Driver.getDriver().findElement(By.id("username"));
        userPasswordText = Driver.getDriver().findElement(By.id("password"));
        submitButton = Driver.getDriver().findElement(By.xpath("//input[@name='login']"));
    }
    @Test
    public void invalidPassword() {
        userNameText.sendKeys("testuser1");
        userPasswordText.sendKeys("Deneme");
        submitButton.click();
        errorMessage = Driver.getDriver().findElement(By.xpath("//li[contains(text(),': The password you entered for the username')]"));
        //errorMessage2 = Driver.getDriver().findElement(By.xpath("//strong[contains(text(),'ERROR')]"));
        errorMesageText = errorMessage.getText();
        Assert.assertTrue(errorMesageText.contains("The password you entered for the username")
                && errorMesageText.contains("is incorrect"));
    }
    @Test
    public void invalidId() {
        userNameText.sendKeys("testuser18");
        userPasswordText.sendKeys("Deneme");
        submitButton.click();
        //errorMessage = Driver.getDriver().findElement(By.xpath("//li[contains(text(),': The password you entered for the username')]"));
        errorMessage2 = Driver.getDriver().findElement(By.xpath("//strong[contains(text(),'ERROR')]"));
        errorMesageText = errorMessage2.getText();
        Assert.assertEquals(errorMesageText, "ERROR");
    }
    @Test
    public void invalidIdAndPassword() {
        userNameText.sendKeys("Deneme");
        userPasswordText.sendKeys("Deneme");
        submitButton.click();
        //errorMessage = Driver.getDriver().findElement(By.xpath("//li[contains(text(),': The password you entered for the username')]"));
        errorMessage2 = Driver.getDriver().findElement(By.xpath("//strong[contains(text(),'ERROR')]"));
        errorMesageText = errorMessage2.getText();
        System.out.println(errorMesageText);
        Assert.assertEquals(errorMesageText, "ERROR");
    }
    @Test
    public void randomNameTest() {
        Faker faker = new Faker();
        String fUserName = faker.name().username();
        String fFullName = faker.name().fullName();
        userNameText.sendKeys(fUserName);
        System.out.println(fUserName);
        userPasswordText.sendKeys(fFullName);
        System.out.println(fFullName);
        submitButton.click();
        //errorMessage = Driver.getDriver().findElement(By.xpath("//li[contains(text(),': The password you entered for the username')]"));
        errorMessage2 = Driver.getDriver().findElement(By.xpath("//strong[contains(text(),'ERROR')]"));
        errorMesageText = errorMessage2.getText();
        System.out.println(errorMesageText);
        Assert.assertEquals(errorMesageText, "ERROR");
    }
}
