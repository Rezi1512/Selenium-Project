package com.sample.www;
import com.sample.www.helpers.*;
import com.sample.www.functions.*;
import com.sample.www.nopcommerce.*;
import common.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC08MiniProject extends TestBase {

    @Test
    public void testi1() throws InterruptedException {
        test = extent.createTest("Test", "test")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");

        LoginPage loginPage= PageFactory.initElements(driver,LoginPage.class);
        loginPage.setDriver(driver);
        MainPage mainPage =PageFactory.initElements(driver, MainPage.class);
        mainPage.setDriver(driver);
        RegisterPage registerPage=PageFactory.initElements(driver, RegisterPage.class);
        registerPage.setDriver(driver);

        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        mainPage.goToLoginPage();

        loginPage.goToRegisterPage();
        System.out.println(driver.getTitle());

        registerPage.registerNewUser(UserData.gender,UserData.emri,UserData.mbiemri,UserData.dit,
                                     UserData.muaj,UserData.vit,UserData.email,UserData.company,
                                     UserData.getNews, UserData.password);
        registerPage.verifyRegisterProcessWasSuccessful();

        mainPage.logOutOfAccount();
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        mainPage.verifyLoginWasSuccessful();
        mainPage.logOutOfAccount();

    }



    @Test
    public void testi2() throws InterruptedException {
        test = extent.createTest("Test", "test")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.setDriver(driver);
        NotebooksPage notebooksPage = PageFactory.initElements(driver,NotebooksPage.class);
        notebooksPage.setDriver(driver);
        LoginPage loginPage= PageFactory.initElements(driver,LoginPage.class);
        loginPage.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        driver.get("https://demo.nopcommerce.com/");
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        mainPage.goToNotebooksPage();
        notebooksPage.verifyUrlOfNotebooksPage();

        notebooksPage.selectNumberOfProductsPerPage("9");
        notebooksPage.verifyNumberOfProductsDisplayed(6);

       // notebooksPage.filterProductsBy16Gb();
       // notebooksPage.verifyNumberOfProductsDisplayed(1);

       // notebooksPage.unfilterProductsBy16Gb();
       // notebooksPage.verifyNumberOfProductsDisplayed(6);

        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");

        notebooksPage.addProductToWishlistByIndex(2);
        notebooksPage.addProductToWishlistByIndex(3);

        notebooksPage.addProductToCartByIndex(4);
        notebooksPage.addProductToCartByIndex(5);
        notebooksPage.addProductToCartByIndex(6);

        notebooksPage.verifyNumberOfProductsInWishlist(2);
        notebooksPage.verifyNumberOfProductsInCart(3);
        mainPage.logOutOfAccount();
    }


    @Test
    public void testi3() throws InterruptedException {
        test = extent.createTest("Test", "test")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");
        //Initialization of page object classes
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.setDriver(driver);
        LoginPage loginPage= PageFactory.initElements(driver,LoginPage.class);
        loginPage.setDriver(driver);
        MyAccountPage myAccountPage = PageFactory.initElements(driver,MyAccountPage.class);
        myAccountPage.setDriver(driver);


        //Navigate to main page and then login
        driver.get("https://demo.nopcommerce.com/");
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        //Go to My Account page and verify we did navigate to my account page
        mainPage.goToMyAccountPage();
        myAccountPage.verifyNavigationToMyAccountPageWasSuccessful();

        //Validate the data of the account
        myAccountPage.verifyUserCredentialsInMyAccountPage(UserData.gender,UserData.emri,
                                                           UserData.mbiemri,UserData.dit,UserData.muaj,
                                                           UserData.vit,UserData.email,UserData.company,
                                                           UserData.getNews, UserData.password);
        mainPage.logOutOfAccount();

    }


    @Test
    public void testi4() throws InterruptedException {
        test = extent.createTest("Test", "test")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //Initialization of page object classes
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.setDriver(driver);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setDriver(driver);
        CartPage cartPage= PageFactory.initElements(driver, CartPage.class);
        cartPage.setDriver(driver);


        //Navigate to main page and then login
        driver.get("https://demo.nopcommerce.com/");
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials(UserData.email,UserData.password);

        //Navigate to cart page after hovering cart menu and verify navigation was successful and buttons are shown
        mainPage.goToCartThroughButtonAfterHoveringCartMenu();
        cartPage.verifyNavigationToCartPageWasSuccessful();
        cartPage.verifyButtonsAreShown();

        //Verify sum of prices is correct
        cartPage.verifySumOfProductsIsCorrect();
        mainPage.logOutOfAccount();

    }



    @Test
    public void testi5() throws InterruptedException {
        test = extent.createTest("Test", "test")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.setDriver(driver);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setDriver(driver);
        CartPage cartPage= PageFactory.initElements(driver,CartPage.class);
        cartPage.setDriver(driver);


        //Navigate to main page and then login
        driver.get("https://demo.nopcommerce.com/");
        mainPage.goToLoginPage();
        loginPage.loginWithCredentials("UserData.email",UserData.password);

        //Navigate to cart page
        mainPage.goToCart();

        //Delete first product and wait for list to update
        cartPage.deleteFirstProduct();
        cartPage.deleteFirstProduct();
        cartPage.deleteFirstProduct();
        //cartPage.waitUntilProductIsRefreshed(cartPage.getProductsRemoveButtonList().get(cartPage.getProductsRemoveButtonList().size()-1));
        //cartPage.deleteAllProductsInCart();
        cartPage.verifyCartIsEmpty();

    }


}

