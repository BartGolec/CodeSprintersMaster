package selenium.basic;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class WordPressTests {

    private Faker faker = new Faker();
    private WebDriver driver;
    private static ChromeOptions options;
    private final String DRIVER_URL = "http://automatyzacja.benedykt.net/";
    private final String COMMENT = faker.chuckNorris().fact();
    private final String EMAIL = UUID.randomUUID().toString() + "@" + UUID.randomUUID().toString() + "." + UUID.randomUUID().toString();
    private final String URL = UUID.randomUUID().toString() + ".com";
    private final String NAME = faker.gameOfThrones().character();

    @BeforeAll
    public static void configSetup() {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver(options);
        driver.get(DRIVER_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkCommentAdditionAtForBenedykt() {
        System.out.println(COMMENT);
        WebElement articleTitle = driver.findElement(By.cssSelector(".entry-title > a"));
        articleTitle.click();

        WebElement commentBox = driver.findElement(By.cssSelector(".comment-form-comment > #comment"));
        commentBox.sendKeys(COMMENT);

        WebElement authorBox = driver.findElement(By.cssSelector(".comment-form-author> #author"));
        authorBox.sendKeys(NAME);

        WebElement emailBox = driver.findElement(By.cssSelector(".comment-form-email> #email"));
        emailBox.sendKeys(EMAIL);

        WebElement urlBox = driver.findElement(By.cssSelector(".comment-form-url> #url"));
        urlBox.sendKeys(URL);

        WebElement submitButton = driver.findElement(By.cssSelector(".form-submit #submit"));
        submitButton.submit();

        List<WebElement> listOfCommentBoxes = driver.findElements(By.cssSelector(".comment-content >p")).stream().filter(a -> a.getText().contains(COMMENT)).collect(Collectors.toList());
        Assertions.assertEquals(1, listOfCommentBoxes.size());

        WebElement myComment = listOfCommentBoxes.get(0);
        Assertions.assertEquals(COMMENT, myComment.getText());
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
