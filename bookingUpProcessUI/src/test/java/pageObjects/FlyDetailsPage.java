package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by wblachut on 2017-05-13.
 */
public class FlyDetailsPage {
    WebDriver driver;

    @FindBy (xpath = "//*[@class=\"data-box flight-summary\"]")
    WebElement flightSummaryDataBox;

    public FlyDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkIfSummaryIsVisible() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(flightSummaryDataBox));
        Thread.sleep(1000);
        return flightSummaryDataBox.isDisplayed();
    }
}
