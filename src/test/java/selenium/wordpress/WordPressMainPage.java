package selenium.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WordPressMainPage {

    private final WebDriver driver;

    public WordPressMainPage (WebDriver driver, String mainUrl){
        this.driver = driver;
        this.driver.get(mainUrl);
    }

    public WordPressArticlePage openFirstArticle(){
        WebElement firstArticleOnMainPage = driver.findElement(By.cssSelector(".entry-title > a"));
        firstArticleOnMainPage.click();
        return new WordPressArticlePage(driver);
    }
}
