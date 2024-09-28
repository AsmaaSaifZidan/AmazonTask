package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchResultsPage {
    WebDriver driver;
    public int Counter;
    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src=\"https://m.media-amazon.com/images/I/71R6ka8Os4L._AC_UL320_.jpg\"]")
    public WebElement firstItem;

    @FindBy(id ="add-to-cart-button")
    WebElement addToCartButton;
    @FindBy(id = "nav-cart-count")
    WebElement CountInCart;
    public AmazonSearchResultsPage selectFirstItem() {

        firstItem.click();
        return this;
    }

    public void ClickOnAddToCartButton() {
        addToCartButton.click();
    }
    public int GEtCountCart() {
     Counter= Integer.parseInt(CountInCart.getText());
     return Counter;
    }
}
