import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.HashMap;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.net.URI;



public class BaseTest {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";



    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("116.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "parkbeomseo0105");
        ltOptions.put("accessKey", "ckgacJlN3BkF09ye8swcDAtWnfCeTiNNbAAMZwhsVcUQcXonc5");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);

    }

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void lunchBrowser(@Optional String baseUrl) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browserName")));
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseUrl;
        getDriver().get(baseUrl);
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.0.0.67:4444";

        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions optionsChrome = new ChromeOptions();
            optionsChrome.addArguments("--disable-notifications", "--remote-allow-origins=*", "--start-maximized");
            optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            return driver = new ChromeDriver(optionsChrome);
        }


        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);

            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
        }
    }

}