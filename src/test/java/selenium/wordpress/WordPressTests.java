package selenium.wordpress;

import org.junit.jupiter.api.Test;

public class WordPressTests extends BasePage {

    @Test
    public void createAndCheckNewCommentInsideFirstArticle(){
        new WordPressMainPage(driver, DRIVER_URL)
                .openFirstArticle()
                .addCommentToArticle(COMMENT, NAME, EMAIL, URL)
                .assertCommentAdditionByCommentContent(COMMENT);
    }
}
