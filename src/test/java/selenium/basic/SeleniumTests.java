package selenium.basic;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SeleniumTests {

    private final String GOOGLE_URL = "https://www.google.pl";
    private final String MARKOWICZ_URL = "http://markowicz.pro/";

    private WebDriver driver;
    static ChromeOptions options;

    @BeforeAll
    public static void chromeDriverSetup() {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void canFinCodeSprintersOnGoogle() {

        driver.get(GOOGLE_URL);
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("Code Sprinters");
        searchbox.submit();

        List<WebElement> googleSearchResults = driver.findElements(By.cssSelector("div.rc"));
        List<WebElement> codeSprrintersList = googleSearchResults.stream().filter(a -> a.findElement(By.cssSelector("div.r > a")).getAttribute("href").equals("http://agileszkolenia.pl/")).collect(Collectors.toList());

        Assertions.assertEquals(1, codeSprrintersList.size(), "Lista nie zawiera 1 elementu");
        WebElement agileSzkoleniaBoxAtGoogle = codeSprrintersList.get(0);

    }

    @Test
    public void verifyAuthorOfBlogNoteAboutTransformation() {
        driver.get(MARKOWICZ_URL);
        List<WebElement> listaArtykulow = driver.findElements(By.className("entry-title")).stream().filter(n -> n.findElement(By.tagName("a")).getText().contains("O transformacjach")).collect(Collectors.toList());
        Assertions.assertEquals(1, listaArtykulow.size());

        driver.findElement(By.cssSelector("#eu-cookie-law input")).submit();

        WebElement oTransformatach = listaArtykulow.get(0);
        oTransformatach.click();

        WebElement autorArtykulu = driver.findElement(By.cssSelector(".author > a"));
        Assertions.assertEquals("Rafał", autorArtykulu.getText());
        Assertions.assertEquals("http://markowicz.pro/author/rafal-markowicz/", autorArtykulu.getAttribute("href"));
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
