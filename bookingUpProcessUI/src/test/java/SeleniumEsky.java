import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.*;

import java.util.Calendar;

/**
 * Created by wblachut on 2017-05-11.
 */
public class SeleniumEsky {

    WebDriver driver;
    String departureDay;
    String arrivalDay;
    String departurePlace;
    String arrivalPlace;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "D:\\userdata\\wblachut\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.esky.pl/");
        Calendar calendar = Calendar.getInstance();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        departureDay = Integer.toString(dayOfMonth + 1);
        arrivalDay = Integer.toString(dayOfMonth + 3);
        departurePlace = "Wroclaw";
        arrivalPlace = "Warszawa";
    }

    @Test
    public void bookingUpProcessFromWroclawToWarsaw() throws InterruptedException {

        EskyMainPage eskyMainPage = new EskyMainPage(driver);
        eskyMainPage.sendTextInDeparturePlaceTextField(departurePlace);
        eskyMainPage.sendTextInArrivalPlaceTextField(arrivalPlace);
        eskyMainPage.clickOnDepartureCalendar();
        eskyMainPage.selectDayFromCalendar(departureDay);
        eskyMainPage.clickOnArrivalCalendar();
        eskyMainPage.selectDayFromCalendar(arrivalDay);
        eskyMainPage.clickOnSerachButton();

        FlySelectPage flySelectPage = new FlySelectPage(driver);
        flySelectPage.clickOnSelectButton();

        FlyDetailsPage flyDetailsPage = new FlyDetailsPage(driver);

        Assert.assertTrue("Summary does not appear", flyDetailsPage.checkIfSummaryIsVisible());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
