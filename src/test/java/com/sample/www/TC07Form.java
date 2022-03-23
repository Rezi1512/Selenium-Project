package com.sample.www;

import common.TestBase;
import org.testng.annotations.Test;

public class TC07Form extends TestBase {

    @Test
    public void chechIfWebElementsAreDisplayed() throws InterruptedException {
        test = extent.createTest("Verify Page Results", "Case 3: User should be able to verify if the page results are ordered in decreasing order of cost.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");

        driver.get("https://demoqa.com/automation-practice-form");


    }
    }
