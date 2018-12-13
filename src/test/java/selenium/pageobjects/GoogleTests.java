package selenium.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageobjects.pages.GoogleMainPage;
import selenium.pageobjects.pages.GoogleResultPage;

public class GoogleTests extends BaseTest {

    @Test
    public void canFindScrumOrgOnGoogle() {
        String url = "https://www.scrum.org/";
        String title = "Scrum.org: Homepage";

        // Open Google Main Page
        GoogleMainPage googleMainPage = new GoogleMainPage(driver);

        // Search for Scrum.org
        GoogleResultPage googleResultPage = googleMainPage.searchFor("Scrum.org");

        // Assert Scrum.org has been found
        Assertions.assertTrue(googleResultPage.checkIfGoogleSearchPageContainsThisUrl(url));
        Assertions.assertTrue(googleResultPage.checkIfGoogleSearchPageContainsThisUrlWithGivenTitle(url, title));
    }

    @Test
    public void canFIndCodeSprinters() {
        String url = "http://agileszkolenia.pl/";
        String title = "Code Sprinters - Agile Experts -";

        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        GoogleResultPage googleResultPage = googleMainPage.searchFor("Code Sprinters");

        Assertions.assertTrue(googleResultPage.checkIfGoogleSearchPageContainsThisUrl(url));
        Assertions.assertTrue(googleResultPage.checkIfGoogleSearchPageContainsThisUrlWithGivenTitle(url, title));
    }

    //go to first article
    //add comment, add if comment exists
}
