package com.sample.www.nopcommerce;

import com.sample.www.functions.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.sample.www.helpers.Helper;

import java.util.List;

public class CartPage {
    Helper helper;
    Functions functions;

    public CartPage(WebDriver driver){
        this.helper=new Helper(driver);
        this.functions=new Functions(driver);
    }
    public void setDriver(WebDriver driver){
        helper=new Helper(driver);
        this.functions=new Functions(driver);
    }

    @FindBy(xpath = "//button[@class='remove-btn'][1]")
    WebElement firstProductRemoveButton;

    @FindBy(xpath = "//button[@class='remove-btn']")
    List<WebElement> productsRemoveButtonList;

    @FindBy(className = "no-data")
    WebElement emptyCartMessage;

    @FindBy(xpath = "//a[@href='/cart']//span[2]")
    WebElement cartNumberOfProductsAdded;

    @FindBy(xpath = "//a[@class='product-name']")
    WebElement firstProductName;

    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement pageMainTitle;

    @FindBy(xpath = "//button[@class='button-2 update-cart-button']")
    WebElement updateShoppingCartButton;

    @FindBy(xpath = "//button[@class='button-2 continue-shopping-button']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@class='estimate-shipping-button']")
    WebElement estimateShippingButton;

    @FindBy(xpath = "//span[@class='product-subtotal']")
    List<WebElement> productsPriceList;

    @FindBy(xpath = "//span[@class='value-summary']//strong")
    WebElement totalSum;

    public List<WebElement> getProductsRemoveButtonList() {
        return productsRemoveButtonList;
    }

    public WebElement getEmptyCartMessage() {
        return emptyCartMessage;
    }

    public WebElement getFirstProductRemoveButton() {
        return firstProductRemoveButton;
    }

    public WebElement getCartNumberOfProductsAdded() {
        return cartNumberOfProductsAdded;
    }

    public WebElement getFirstProductName() {
        return firstProductName;
    }

    public WebElement getPageMainTitle() {
        return pageMainTitle;
    }

    public WebElement getUpdateShoppingCartButton() {
        return updateShoppingCartButton;
    }

    public WebElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public WebElement getEstimateShippingButton() {
        return estimateShippingButton;
    }

    public List<WebElement> getProductsPriceList() {
        return productsPriceList;
    }

    public WebElement getTotalSum() {
        return totalSum;
    }


    public void deleteFirstProduct(){
        if(productsRemoveButtonList.size()>0) {
            helper.clickElement(firstProductRemoveButton);
        }
    }


    public void deleteProductByIndex(int index){
        if(index<productsRemoveButtonList.size()){
            helper.clickElement(productsRemoveButtonList.get(index));
        }
    }


    public void deleteAllProductsInCart() {
        int totalOfProducts=helper.getNumberOfElements(productsRemoveButtonList);
        for(int i=totalOfProducts-1;i>=0;i--){
            deleteProductByIndex(i);
            helper.waitForTextOfElementToBe("//a[@href='/cart']//span[2]","("+(i)+")");
            verifyNumberOfProductsInCart(i);
        }
    }


    public void verifyNumberOfProductsInCart(int nr){
        int total=helper.getNumberOfElements(productsRemoveButtonList);
        Assert.assertEquals(total,nr);
    }


    public void verifyCartIsEmpty(){
        Assert.assertTrue(emptyCartMessage.isDisplayed());
    }


    public void verifyNavigationToCartPageWasSuccessful(){
        helper.assertElementIsVisible(pageMainTitle);
    }


    public void verifyButtonsAreShown(){
        helper.assertElementIsVisible(updateShoppingCartButton);
        helper.assertElementIsVisible(continueShoppingButton);
        helper.assertElementIsVisible(estimateShippingButton);
    }


    public void verifySumOfProductsIsCorrect(){
        double sum=0;
        double total=functions.convertToDouble(totalSum.getText());
        for(WebElement element: productsPriceList){
            sum+=functions.convertToDouble(element.getText());
        }
        Assert.assertEquals(sum,total);
    }

}

