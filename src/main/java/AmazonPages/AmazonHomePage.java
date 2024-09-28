package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    WebDriver driver;

     public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id ="nav-search-submit-button")
    WebElement searchSubmitSign;
    public void searchForItem(String searchTerm) {
        searchBox.sendKeys(searchTerm);
        searchSubmitSign.click();
    }
}
