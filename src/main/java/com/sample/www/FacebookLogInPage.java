package com.sample.www;

import org.openqa.selenium.By;

public class FacebookLogInPage {

    public static By title = By.cssSelector(".fb_logo");
    public static By description = By.tagName("h2");
    public static By email = By.id("email");
    public static By password = By.id("pass");
    public static By logInButton = By.name("login");
    public static By forgotPassword = By.linkText("Forgot password");
    public static By createNewAccountButton = By.cssSelector("_6ltg > a");


}
