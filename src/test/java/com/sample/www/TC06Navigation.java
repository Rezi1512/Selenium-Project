package com.sample.www;

import common.TestBase;
import org.testng.annotations.Test;

public class TC06Navigation extends TestBase {
/**
    @Test
    public void chechIfWebElementsAreDisplayed() throws InterruptedException {
        test = extent.createTest("Verify Page Results", "Case 3: User should be able to verify if the page results are ordered in decreasing order of cost.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");

        driver.get("http://qatechhub.com");
        String title="QA Automation Tools Trainings and Tutorials | QA Tech Hub" ;

        if (driver.getTitle().equals(title)){
            System.out.println("Pass");
            System.out.println(title);
            System.out.println(driver.getTitle());
        }
        else {
            System.out.println("Fail");
            System.out.println(title);
            System.out.println(driver.getTitle());
        }

        driver.get("https://www.facebook.com");

        String strUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ strUrl);

        driver.navigate().back();
        String strUrl1 = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ strUrl1);

        driver.navigate().forward();
        String strUrl2 = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ strUrl2);

        driver.navigate().refresh();

        driver.quit();



    }
    */
}
