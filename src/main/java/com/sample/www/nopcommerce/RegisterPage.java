package com.sample.www.nopcommerce;

import com.sample.www.functions.Functions;
import com.sample.www.helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    private Helper helpers;
    public Functions functions;

    public RegisterPage(WebDriver driver){
        this.helpers=new Helper(driver);
        this.functions=new Functions(driver);
    }

    public void setDriver(WebDriver driver){
        this.helpers=new Helper(driver);
        this.functions=new Functions(driver);
    }

    @FindBy(css = "span.male > label")
    private WebElement maleRadioButton;

    @FindBy(css = "span.female > label")
    private WebElement femaleRadioButton;

    @FindBy(id = "FirstName")
    private WebElement firstnameTextBox;

    @FindBy(id = "LastName")
    private WebElement lastnameTextBox;

    @FindBy(name = "DateOfBirthDay")
    private WebElement daySelectlist;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement monthSelectList;

    @FindBy(name = "DateOfBirthYear")
    private WebElement yearSelectList;

    @FindBy(id = "Email")
    private WebElement emailTextBox;

    @FindBy(id = "Company")
    private WebElement companyTextBox;

    @FindBy(id = "Newsletter")
    private WebElement newsletterCheckBox;

    @FindBy(id = "Password")
    private WebElement passwordTextBox;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextBox;

    @FindBy(id = "register-button")
    private WebElement completeRegisterButton;

    @FindBy(className = "result")
    private WebElement registerResultTextElement;

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public WebElement getFirstnameTextBox() {
        return firstnameTextBox;
    }

    public WebElement getLastnameTextBox() {
        return lastnameTextBox;
    }

    public WebElement getDaySelectList() {
        return daySelectlist;
    }

    public WebElement getMonthSelectList() {
        return monthSelectList;
    }

    public WebElement getYearSelectList() {
        return yearSelectList;
    }

    public WebElement getEmailTextBox() {
        return emailTextBox;
    }

    public WebElement getCompanyTextBox() {
        return companyTextBox;
    }

    public WebElement getNewsletterCheckBox() {
        return newsletterCheckBox;
    }

    public WebElement getPasswordTextBox() {
        return passwordTextBox;
    }

    public WebElement getConfirmPasswordTextBox() {
        return confirmPasswordTextBox;
    }

    public WebElement getCompleteRegisterButton() {
        return completeRegisterButton;
    }

    public WebElement getRegisterResultTextElement() {
        return registerResultTextElement;
    }

    public void registerNewUser(String gender, String emri,String mbiemri,String dita,String muaj,
                                String viti, String email, String company,boolean getNews,
                                String password) throws InterruptedException {

        if (gender.equalsIgnoreCase("m")) {
            helpers.clickElement(maleRadioButton);
        }else{
            helpers.clickElement(femaleRadioButton);
        }
        helpers.sendKeys(firstnameTextBox,emri);
        helpers.sendKeys(lastnameTextBox,mbiemri);
        helpers.selectByVisibleText(daySelectlist,dita);
        helpers.selectByVisibleText(monthSelectList,muaj);
        helpers.selectByVisibleText(yearSelectList,viti);
        helpers.sendKeys(emailTextBox,email);
        helpers.sendKeys(companyTextBox,company);
        if(getNews!=helpers.isElementSelected(newsletterCheckBox)){
            helpers.clickElement(newsletterCheckBox);
        }
        helpers.sendKeys(passwordTextBox,password);
        helpers.sendKeys(confirmPasswordTextBox,password);
        helpers.clickElement(completeRegisterButton);

    }

    public void verifyRegisterProcessWasSuccessful(){
        helpers.assertElementHasText(registerResultTextElement,"Your registration completed");
    }

}

