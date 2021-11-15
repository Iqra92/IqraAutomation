package Automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPage {

    WebDriver ldriver;

    public GoogleSearchPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    public GoogleSearchPage() {
    }

    @FindBy(how = How.NAME, using = "q")
    @CacheLookup
    WebElement txtq;
    @FindBy(name="btnK")
    @CacheLookup
    WebElement googleSubmitBtn;

    @FindBy(xpath="//*[@id='i0']/div/a/div[2]/div[1]/div/picture/img")
    @CacheLookup
    WebElement selectProductClick;
    @FindBy(id ="product-name")
    @CacheLookup
    WebElement getProductTitle;
    @FindBy(css ="body > div.wrapper > main > div.product-detail-module > section.detail-main > div.container.contain-lg-4.contain-md-4.contain-sm-1.fluid > div > div.productDetailRight.col.lg-2.md-2.sm-1.grid-demo-fluid > div.product-information.col.lg-5.sm-1 > div.product-price-wrapper > div > div.price-wrapper.visible > div.product-price.price-container.big")
    @CacheLookup
    WebElement productPrice;
    @FindBy(css = "#offering-price")
    @CacheLookup
    WebElement ListingPrice;
    @FindBy(xpath = "//*[@class ='moria-ProductCard-aBQpD ctVXlM s6j45uzcqf0']")
//    @FindBy(xpath = "//*[@data-test-id='price-current-price']")
    @CacheLookup
    WebElement CardPrice;
    @FindBy(xpath = "//*[@id='rso']/div[3]/div/div/div[1]/a/h3")
    @CacheLookup
    WebElement openLink;
//css = "#rso > div:nth-child(29) > div > div > div.yuRUbf > a
//*[@id="rso"]/div[3]/div/div/div[1]/a/h3
//*[@id="rso"]/div[3]/div/div/div[1]/div/div/div/div[1]/a/h3
//*[@id="rso"]/div[3]/div/div/div[1]/a/h3
//*[@id="rso"]/div[3]/div/div/div[1]/div/div/div/div[1]/a/h3
//*[@id="rso"]/div[3]/div/div/div[1]/a/h3

    @FindBy(id  = "i0")
    @CacheLookup
    WebElement getWholeProduct;

    public WebElement getProductList() {

//        for (WebElement option : optionsToSelect) {
//            List<WebElement> textPerLi= option .findElements(By.tagName("div"));
//            for(WebElement option2 : optionsToSelect2 ){
//                List<WebElement>  text2 = option2.findElements(By.xpath("//*[@data-test-id='price-current-price']"));
//
//            }

//.findElement(By.xpath("//*[@data-test-id='price-current-price']")).getText();
//        }
        return  getWholeProduct;
    }


    public void SearchName(String cname) {

        txtq.sendKeys(cname);
    }


    public void clickSubmit()
    {

        googleSubmitBtn.click();
    }

    public void productSelectedClick()
    {

        selectProductClick.click();
    }

    public void openSecondLink()
    {

        openLink.click();
    }

    public String getProductTitle() {

        return getProductTitle.getText();
    }
    public String getProductPrice(){

        return productPrice.getText();
    }
    public String getCardPrice(){

        return CardPrice.getText();
    }

    public String getListingProductPrice(){

        return ListingPrice.getText();
    }
    @FindBy(id="addToCart")
    @CacheLookup
    WebElement addToCart;

    @FindBy(id="shoppingCart")
    @CacheLookup
    WebElement shoppingCart;
    public void addToCart(){
        addToCart.click();
    }
    public void shoppingCart(){
        shoppingCart.click();
    }

}
