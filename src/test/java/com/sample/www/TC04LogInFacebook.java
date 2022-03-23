package com.sample.www;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04LogInFacebook extends TestBase {

    @Test
    public void chechIfWebElementsAreDisplayed() throws InterruptedException {
        test = extent.createTest("Verify Page Results", "Case 3: User should be able to verify if the page results are ordered in decreasing order of cost.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");


        driver.get("https://www.facebook.com");


        WebElement title = driver.findElement(FacebookLogInPage.title);
        Assert.assertTrue(title.isDisplayed());


        WebElement desc = driver.findElement(FacebookLogInPage.description);
        logger.info(desc.getText());

        WebElement email = driver.findElement(FacebookLogInPage.email);
        email.sendKeys("hfkjadfhkajd@nfjkd.com");

        WebElement pass = driver.findElement(FacebookLogInPage.password);
        pass.sendKeys("12345678");

        WebElement logIn = driver.findElement(FacebookLogInPage.logInButton);
        logIn.click();

        Thread.sleep(5000);
    }
}
