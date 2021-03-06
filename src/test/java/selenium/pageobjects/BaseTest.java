package selenium.pageobjects;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static ChromeOptions options;
    protected WebDriver driver;
    protected String randomString = UUID.randomUUID().toString();

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    @BeforeEach
    public void startBrowser() {
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void quitBrowser() {
        driver.quit();
    }
}
