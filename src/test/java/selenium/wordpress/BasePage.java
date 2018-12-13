package selenium.wordpress;

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

    protected final String DRIVER_URL = "http://automatyzacja.benedykt.net/";
    protected WebDriver driver;
    protected static ChromeOptions options;
    private Faker faker = new Faker();
    protected final String COMMENT = UUID.randomUUID().toString();
    protected final String EMAIL = UUID.randomUUID().toString() + "@" + UUID.randomUUID().toString() + "." + UUID.randomUUID().toString();
    protected final String URL = UUID.randomUUID().toString() + ".com";
    protected final String NAME = faker.gameOfThrones().character();

    @BeforeAll
    public static void config(){
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    @BeforeEach
    public void setupDriver(){
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterEach
    public void closeDriver(){
        driver.quit();
    }
}
