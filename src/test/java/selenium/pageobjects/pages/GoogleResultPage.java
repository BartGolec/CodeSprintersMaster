package selenium.pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleResultPage {

    public static final By RESULT_LOCATION = By.cssSelector("#search .rc .r");
    private final WebDriver grpDriver;

    public GoogleResultPage(WebDriver driver) {
        grpDriver = driver;
    }

    public boolean checkIfGoogleSearchPageContainsThisUrl(String resultURL) {
        List<WebElement> googleSearchResults = getResultsByUrl(resultURL);
        return googleSearchResults.size() > 0;
    }

    public boolean checkIfGoogleSearchPageContainsThisUrlWithGivenTitle(String pageUrl, String pageTitle) {
        List <WebElement> resultsWithCertainTitle = getResultsByUrl(pageUrl).stream().filter(a -> a.findElement(By.tagName("h3")).getText().equals(pageTitle)).collect(Collectors.toList());

        return resultsWithCertainTitle.size() > 0;
    }

    private List<WebElement> getResultsByUrl(String resultURL) {
        return grpDriver.findElements(RESULT_LOCATION)
                .stream().filter(a -> a.findElement(By.tagName("a")).getAttribute("href").equals(resultURL)).collect(Collectors.toList());
    }
}
