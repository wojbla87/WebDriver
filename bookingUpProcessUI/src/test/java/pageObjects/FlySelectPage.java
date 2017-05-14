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
public class FlySelectPage {

    WebDriver driver;

    @FindBy (xpath = ".//*[@id='available-flights']/form[1]/div[1]/a")
    private WebElement firstAvailableSelectFlyButton;

    public FlySelectPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSelectButton() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(firstAvailableSelectFlyButton));
        Thread.sleep(1000);
        firstAvailableSelectFlyButton.click();
    }


}
