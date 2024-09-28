package TestPages;

import AmazonPages.AmazonCartPage;
import AmazonPages.AmazonHomePage;
import AmazonPages.AmazonSearchResultsPage;
import AmazonPages.AmazonTodayDeals;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import utils.Utils;
public class AmazonTest extends BaseTest {
    AmazonHomePage amazonHomePage;
    AmazonSearchResultsPage amazonSearchResultsPage;
    AmazonCartPage amazonCartPage;
    AmazonTodayDeals amazonTodayDeals;
    @Test
    public void addItemToCartTest() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonSearchResultsPage = new AmazonSearchResultsPage(driver);
        amazonCartPage = new AmazonCartPage(driver);
        amazonHomePage.searchForItem("car accessories");
        Utils.handleAlert(driver);
        Utils.scrollToElement(driver,amazonSearchResultsPage.firstItem);
        amazonSearchResultsPage.selectFirstItem();
        amazonSearchResultsPage.ClickOnAddToCartButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(amazonCartPage.isItemAddedToCart(),"Added to Cart","Item not added to the cart successfully!");
        amazonCartPage.GoToCart();
      Assert.assertEquals(amazonSearchResultsPage.Counter,0);
    }
    @Test
    public void AmazonTodayDeals(){
        amazonTodayDeals= new AmazonTodayDeals(driver);
        amazonTodayDeals.ClickOnTodayDealsButton();
        Utils.scrollToElement(driver,amazonTodayDeals.seeMoreDepartments);
        amazonTodayDeals.ClickOnSeeMoreDepartments();
        Utils.scrollToElement(driver,amazonTodayDeals.HeadPhones);
        amazonTodayDeals.ClickOnHeadPhones();
        amazonTodayDeals.ClickOnGrocery();
        Utils.scrollToElement(driver,amazonTodayDeals.Offer);
        amazonTodayDeals.ClickOnOffer();
        Utils.scrollToElement(driver,amazonTodayDeals.Item);
        amazonTodayDeals.ClickOnAnyItem();
        amazonSearchResultsPage.ClickOnAddToCartButton();
        Assert.assertEquals(amazonCartPage.isItemAddedToCart(),"Added to Cart","Item not added to the cart successfully!");

    }
}
