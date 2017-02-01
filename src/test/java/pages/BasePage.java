package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by thanhnguyen on 1/31/17.
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void findAndClickElement(By locator, int index) {
        waitForVisibilityOf(locator);
        driver.findElements(locator).get(index).click();
    }

    protected void pageLoaded(By locator){
        waitForVisibilityOf(locator);
    }

    protected String getTextElement(By locator){
        waitForVisibilityOf(locator);
        return driver.findElement(locator).getText();
    }

    protected void findAndSentTextElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean isElementDisplayed(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    protected Integer findAndCountItems(By locator) {
        if (isElementDisplayed(locator) == true) {
            return driver.findElements(locator).size();
        }else{
            return 0;
        }
    }
}
