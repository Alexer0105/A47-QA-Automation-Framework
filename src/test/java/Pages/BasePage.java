package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver = null;
    protected WebDriverWait wait = null;
    protected Actions actions = null;

    private int timeSeconds = 5;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeSeconds), this);
    }


    protected WebElement findElement(WebElement WebElement) {
        return wait.until(ExpectedConditions.visibilityOf(WebElement));
    }

    protected void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    protected void doubleClick(WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();

    }

    protected void contextClick(WebElement webElement) {
        actions.contextClick(findElement(webElement)).perform();
    }

}
