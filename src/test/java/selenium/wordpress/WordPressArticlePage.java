package selenium.wordpress;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WordPressArticlePage {

    private WebDriver driver;

    WordPressArticlePage (WebDriver driver){
        this.driver = driver;
    }

    public WordPressArticlePage addCommentToArticle(String comment, String name, String email, String url){
        WebElement commentBox = driver.findElement(By.cssSelector(".comment-form-comment > #comment"));
        commentBox.sendKeys(comment);

        WebElement authorBox = driver.findElement(By.cssSelector(".comment-form-author> #author"));
        authorBox.sendKeys(name);

        WebElement emailBox = driver.findElement(By.cssSelector(".comment-form-email> #email"));
        emailBox.sendKeys(email);

        WebElement urlBox = driver.findElement(By.cssSelector(".comment-form-url> #url"));
        urlBox.sendKeys(url);

        WebElement submitButton = driver.findElement(By.cssSelector(".form-submit #submit"));
        submitButton.submit();

        return this;
    }

    public WordPressArticlePage assertCommentAdditionByCommentContent(String comment){
        List<WebElement> listOfCommentBoxes = driver.findElements(By.cssSelector(".comment-content >p")).stream().filter(a -> a.getText().equals(comment)).collect(Collectors.toList());
        Assertions.assertEquals(1, listOfCommentBoxes.size());

        WebElement myComment = listOfCommentBoxes.get(0);
        Assertions.assertEquals(comment, myComment.getText());
        return this;
    }
}
