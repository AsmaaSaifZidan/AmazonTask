package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonTodayDeals {
    WebDriver driver;
    public int Counter;
    public AmazonTodayDeals(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@data-csa-c-id=\"ytkzug-lwebve-b3s2t5-c03bl\"]")
    WebElement TodayDealsButton;
    public @FindBy(xpath = "//a[@aria-labelledby=\"see-more-departments-label\"]")
    WebElement seeMoreDepartments;
   public @FindBy(linkText = "Cell Phones & Accessories")
    WebElement HeadPhones;
    @FindBy(linkText = "Grocery & Gourmet Food")
    WebElement Grocery;
   public @FindBy(linkText = "10% off or more")
    WebElement Offer;
   public @FindBy(xpath = "//img[@ src=\"https://m.media-amazon.com/images/I/71OvmyXFEIL._AC_SF226,226_QL85_.jpg?aicid=discounts-widgets-horizonte\"]")
    WebElement Item;
    @FindBy(id = "add-to-cart-button")
    WebElement AddToCart;
    public void ClickOnTodayDealsButton() {
        TodayDealsButton.click();
    }
    public void ClickOnSeeMoreDepartments() {
        seeMoreDepartments.click();
    }
    public void ClickOnHeadPhones() {
        HeadPhones.click();
    }

    public void ClickOnGrocery() {
        Grocery.click();
    }
    public void ClickOnOffer() {
        Offer.click();
    }
    public void ClickOnAnyItem() {
        Item.click();
    }
    public void ClickOnAddToCart() {
        AddToCart.click();
    }

}
