package selenium.wordpressadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordpressAdminMainPage {

    @FindBy(css = ".wp-has-submenu.wp-not-current-submenu.menu-top.menu-icon-post.open-if-no-js.menu-top-first")
    private WebElement hooverButtons;

    @FindBy(css = "a[href=\"post-new.php\"]")
    private WebElement addNewArticleButton;

    private WebDriver driver;

    public WordpressAdminMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WordpressAddNewArticlePage goToAddNewArticlePage() {
        Actions action = new Actions(driver);
        action.moveToElement(hooverButtons).build().perform();
        addNewArticleButton.click();
        return PageFactory.initElements(driver, WordpressAddNewArticlePage.class);
    }
}
