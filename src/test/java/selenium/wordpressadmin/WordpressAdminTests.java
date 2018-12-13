package selenium.wordpressadmin;

import org.junit.jupiter.api.Test;

public class WordpressAdminTests extends BasePage {

    @Test
    public void addNewCommentAsAdminAndLogout(){
        new LoginPage(driver, BASE_URL)
                .loginWithUserAndPassword(USERNAME_ADMIN, PASSWORD_ADMIN)
                .goToAddNewArticlePage()
                .addNewArticle(title, comment)
                .logout()
                .assertLogingOut("https://automatyzacja.benedykt.net/wp-login.php?loggedout=true");
    }
}
