package com.sample.www.functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {

    WebDriver driver;
    WebDriverWait waiter;

    public Functions(WebDriver driver){
        this.driver=driver;
        this.waiter=new WebDriverWait(driver,5);
    }

    public static double convertToDouble(String temp){
        String a = temp;
        String s = a.replaceAll(",","").trim();
        String b=s.substring(1);
        double result = Double.parseDouble(b);
        return result;
    }




}
