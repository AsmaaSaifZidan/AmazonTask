package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCartPage {
    WebDriver driver;
    public AmazonCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "nav-cart")
    WebElement goToCartButton;
    @FindBy(xpath ="//h1[@class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]")
    WebElement addedItem;
    public void GoToCart() {
        goToCartButton.click();
    }

    public String isItemAddedToCart() {
        return addedItem.getText();
    }
}
