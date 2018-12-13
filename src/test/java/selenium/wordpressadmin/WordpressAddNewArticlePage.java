package selenium.wordpressadmin;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordpressAddNewArticlePage {

    @FindBy(css = "#title")
    private WebElement inputTitleBox;

    @FindBy(css = "#wp-content-editor-container > .wp-editor-area")
    private WebElement inputCommentBox;

    @FindBy(css = "#publish")
    private WebElement publishButton;

    @FindBy(css = "#wp-admin-bar-my-account")
    private WebElement adminBarPopupMenu;

    @FindBy(css = "#wp-admin-bar-logout > a[href^=\"https://automatyzacja.benedykt.net/wp-login.php?action=logout&_wpnonce=31d1522aab\"]\t")
    private WebElement logoutButton;

    private WebDriver driver;

    public WordpressAddNewArticlePage(WebDriver driver){
        this.driver = driver;
    }

    public WordpressAddNewArticlePage addNewArticle(String title, String comment){
        inputTitleBox.sendKeys(title);
        inputCommentBox.sendKeys(comment);
        publishButton.submit();
    return PageFactory.initElements(driver, WordpressAddNewArticlePage.class);
    }

    public WordpressAddNewArticlePage logout(){
        Actions action = new Actions(driver);
        action.moveToElement(adminBarPopupMenu);
        logoutButton.click();
        return PageFactory.initElements(driver, WordpressAddNewArticlePage.class);
    }

    public void assertLogingOut(String url){
        Assertions.assertEquals(driver.getCurrentUrl(), url);
    }



}
