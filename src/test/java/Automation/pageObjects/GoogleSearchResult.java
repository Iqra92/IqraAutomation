package Automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult {

    WebDriver ldriver;

    public GoogleSearchResult(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
//    @FindBy(name="btnK")
//    @CacheLookup
//    WebElement clickOnSecondLink;

    @FindBy(xpath="*[@id='rso']/div[4]/div/div[1]/div/div/div/div[1]/a/h3")
    @CacheLookup
    WebElement openLink;


//    public void clickSubmit()
//    {
//        clickOnSecondLink.click();
//    }

    public void openSecondLink()
    {

        openLink.click();
    }
}
