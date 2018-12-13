package selenium.pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {

    private static final String GOOGLE_PAGE_URL = "http://www.google.com";
    public static final By SEARCH_BOX = By.name("q");
    private final WebDriver driver;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(GOOGLE_PAGE_URL);
    }

    public GoogleResultPage searchFor(String searchText) {
        WebElement searchBox = driver.findElement(SEARCH_BOX);
        searchBox.sendKeys(searchText);
        searchBox.submit();

        return new GoogleResultPage(driver);
    }
}
