package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.testng.Assert;



public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    @FindBy(css = "[type = 'email']")
    private WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type='email']")));

    @FindBy(css = "[type = 'password']")
    private WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));

    @FindBy(css = "button[type = 'submit']")
    private WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));


    public LoginPage openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
        return this;
    }

    public LoginPage provideEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    public LoginPage getAvatar() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
        return this;
    }

    public void login() {
        provideEmail("beomseo.park@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

    }

}
