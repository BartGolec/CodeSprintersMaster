package selenium.wordpressadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

    @FindBy(css = "#user_login")
    private WebElement loginUserInput;

    @FindBy(css = "#user_pass")
    private WebElement loginPasswordInput;

    @FindBy(css = "#wp-submit")
    private WebElement submitButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver, String loginPageUrl){
        this.driver = driver;
        this.driver.get(loginPageUrl);
        PageFactory.initElements(driver, this);
    }

    public WordpressAdminMainPage loginWithUserAndPassword(String username, String password){
        loginUserInput.clear();
        loginUserInput.sendKeys(username);
        loginPasswordInput.clear();
        loginPasswordInput.sendKeys(password);
        submitButton.submit();

        return PageFactory.initElements(driver, WordpressAdminMainPage.class);
    }
}
