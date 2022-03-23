package com.sample.www;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TC05HomeWork extends TestBase {

    @Test
    public void chechIfWebElementsAreDisplayed() throws InterruptedException {
        test = extent.createTest("Verify Page Results", "Case 3: User should be able to verify if the page results are ordered in decreasing order of cost.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");


        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(HomeWork.searchBox);
        searchBox.sendKeys("Amazon");
        WebElement kerkoNeGoogle = driver.findElement(HomeWork.kerkoNeGoogle);
        kerkoNeGoogle.click();
        WebElement amazon = driver.findElement(HomeWork.amazon);
        amazon.click();
        WebElement amazonSearchBox = driver.findElement(HomeWork.amazonSearchBox);
        amazonSearchBox.sendKeys("Iphone13");
        WebElement searchButton = driver.findElement(HomeWork.searchButton);
        searchButton.click();

       // Thread.sleep(2000);

        WebElement iphone = driver.findElement(HomeWork.iphone);
        iphone.click();
        WebElement buyNow = driver.findElement(HomeWork.buyNow);
        buyNow.click();
        WebElement amazonAccount = driver.findElement(HomeWork.amazonAccount);
        amazonAccount.click();
        WebElement name = driver.findElement(HomeWork.name);
        name.sendKeys("Amazon");
        WebElement number = driver.findElement(HomeWork.number);
        number.sendKeys("123456789");
        WebElement password = driver.findElement(HomeWork.password);
        password.sendKeys("aaaaa");
        WebElement passwordAgain = driver.findElement(HomeWork.passwordAgain);
        passwordAgain.sendKeys("aaaaa");

       // Thread.sleep(2000);
        name.clear();
        number.clear();
        password.clear();
        passwordAgain.clear();
       // Thread.sleep(2000);










    }
}
