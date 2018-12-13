package selenium.wordpressadmin;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    private static ChromeOptions options;
    protected static String BASE_URL = "https://automatyzacja.benedykt.net/wp-admin";
    protected Faker faker = new Faker();
    protected final String title = faker.gameOfThrones().character();
    protected final String comment = UUID.randomUUID().toString();
    protected final static String USERNAME_ADMIN = "automatyzacja";
    protected final static String PASSWORD_ADMIN = "jesien2018";

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void shutdownDriver() {
        driver.quit();
    }
}
