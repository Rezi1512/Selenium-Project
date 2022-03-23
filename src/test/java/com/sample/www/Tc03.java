package com.sample.www;

import common.TestBase;
import org.testng.annotations.Test;


public class Tc03 extends TestBase {
    @Test
    public void navigate() throws InterruptedException {

        test = extent.createTest("Verify URL", "Case 5: User needs to verify if Youtube homepage works as expected.")
                .assignCategory("Functional__testcase")
                .assignAuthor("Kunl");
        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        driver.get("https://www.youtube.com/");


    }
}
