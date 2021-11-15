package Automation.testCases;

import Automation.pageObjects.GoogleSearchPage;
import Automation.pageObjects.GoogleSearchResult;
import Automation.utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_GoogleSearchKey_001 extends BaseClass {

    String productPrice;

    String actualListingPrice;
    String cartPrice;

    //@Parameters({"browser"})   // ---Run with testng.xml
    @Test
    public void googleSearchKey() throws IOException {
        logger.info("URL is opened");
        GoogleSearchPage gb = new GoogleSearchPage(driver);
        driver.manage().window().maximize();
        gb.SearchName(Constants.SEARCH_KEYWORD);
        gb.clickSubmit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        gb.openSecondLink();
        System.out.println("Open Second Link -> Test Passed");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//        if(driver.getCurrentUrl().equals(Constants.SECOND_URL_LINK)){
//            Assert.assertTrue(true);
//            logger.info("Second URL test passed");
//        }
//        else{
//            Assert.assertFalse(false);
//            logger.info("Second URL test failed");
//        }

        selectProduct(gb);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Product Open -> Test Pass");
        getProductData(gb);
        addToCart(gb);
         shoppingCart(gb);

    }

    private void selectProduct(GoogleSearchPage gb) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //id
        getProductList(gb);
    }

    private void getProductData(GoogleSearchPage gb) throws IOException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        productPrice =    gb.getProductPrice();
         actualListingPrice = gb.getListingProductPrice();
        System.out.println("listing Price:"+actualListingPrice);

//        logger.info(gb.getProductTitle()+"TEST");
        File file1 = new File("Product.txt");
        FileWriter fw = new FileWriter(file1);
        PrintWriter printFile = new PrintWriter(fw);

        printFile.println(gb.getProductTitle()+" "+"Product Price:"+actualListingPrice);
        printFile.close();

    }

    private void addToCart(GoogleSearchPage gb){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        gb.  addToCart();
    }

    private void shoppingCart(GoogleSearchPage gb) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        gb.shoppingCart();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Result=> "+actualListingPrice.replace("TL","") +"==="+cartPrice.replace("TL",""));
        if(actualListingPrice.equals(cartPrice))
        {
            System.out.println("Test Passed");

            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("else failed..");

            Assert.assertFalse(false);
        }

    }


    private void getProductList(GoogleSearchPage gb){
        System.out.println(gb.getProductList().findElement(By.xpath("//*[@data-test-id='price-current-price']")).getText());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        gb.getProductList().findElement(By.xpath("//*[@id='i0']/div/a/div[2]/div[1]/div/picture/img")).click();
    }
}
