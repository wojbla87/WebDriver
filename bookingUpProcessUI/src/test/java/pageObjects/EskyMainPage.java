package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by wblachut on 2017-05-11.
 */
public class EskyMainPage {

    WebDriver driver;

    By idDeparture = By.id("departureRoundtrip0");

    By idArrival = By.id("arrivalRoundtrip0");

    @FindBy(xpath = ".//*[@id='departureDateRoundtrip0']/following-sibling::button")
    private WebElement departureDateCalendarIcon;

    @FindBy(xpath = ".//*[@id='departureDateRoundtrip1']/following-sibling::button")
    private WebElement arrivalDateCalendarIcon;

    @FindBy(xpath = ".//*[@id='ui-datepicker-div']/table//td")
    private List<WebElement> datePicker;

    @FindBy(xpath = ".//*[@class='btn transaction qsf-search']")
    private WebElement searchButton;


    public EskyMainPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnDepartureCalendar() {
        departureDateCalendarIcon.click();
    }

    public void clickOnArrivalCalendar() {
        arrivalDateCalendarIcon.click();
    }

    public void sendTextInDeparturePlaceTextField(String test) {
        WebElement element = driver.findElement(idDeparture);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(test);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }

    public void sendTextInArrivalPlaceTextField(String test) {
        WebElement element = driver.findElement(idArrival);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(test);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }

    public void clickOnSerachButton() {
        searchButton.click();
    }

    public void selectDayFromCalendar(String day) {

        for (WebElement dayFromCalendar : datePicker) {
            if (dayFromCalendar.getText().equals(day)) {
                dayFromCalendar.click();
                break;
            }
        }
    }


}
