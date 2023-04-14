package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
    private WebDriver driver;
    public By searchBox = By.id("twotabsearchtextbox");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(By locator) {
        WebElement ele = driver.findElement(locator);
        ele.sendKeys("Laptops");
        driver.findElement(searchBox).submit();
    }
}