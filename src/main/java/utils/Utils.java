package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

public class Utils {

     // Check for CAPTCHA and pause for manual intervention.

    public static void handleCaptcha(WebDriver driver, String targetUrlSubstring) {
        if (Objects.requireNonNull(driver.getPageSource()).contains("Type the characters you see in this image")) {
            System.out.println("CAPTCHA detected. Please solve it manually.");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Adjust the timeout as needed

            try {
                 wait.until(new Function<WebDriver, Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return Objects.requireNonNull(driver.getCurrentUrl()).contains(targetUrlSubstring);
                    }
                });
                System.out.println("Target URL substring appeared in the current URL. Continuing...");
            } catch (TimeoutException e) {
                System.out.println("Timed out waiting for the target URL substring to appear.");
                e.printStackTrace();
            }
        }
    }


    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void handleAlert(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert found: " + alert.getText());
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }
    }

}
