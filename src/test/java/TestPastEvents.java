import com.epam.test.driver.WebDriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPastEvents {

    private FirefoxDriver driver;
    final static Logger logger = LogManager.getLogger(TestPastEvents.class);

    @BeforeTest
    public void initDriver() {
        driver = WebDriverSingleton.getDriver();
        driver.get("https://www.epam.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testPastEvents() {
        waitElementByTime(60);
        clickOnCookieAccept();
        clickOnAbout();
        verifyAboutBtn();
        clickOnEvents();
        verifyEventBtn();
        clickOnPastEvents();
        verifyPastEventsBtn();
        clickOnLearnMore();
        ifExistFacebookBtn();
        verifyFacebookBtn();
    }


    public void clickOnCookieAccept() {
        driver.findElement(By.xpath("//button[@class=\"button-ui bg-color-light-blue cookie-disclaimer__button\"]")).click();
        logger.info("Click on \"Cookie Accept\" button");
    }

    public void clickOnAbout() {
        driver.findElement(By.xpath("//*[@class=\"top-navigation__item-text\"]/a[contains(text(),\"About\")]")).click();
        logger.info("Click on \"About\" button");
    }

    public void verifyAboutBtn() {
        String titleName = driver.findElement(By.xpath("//div[@class=\"title\"]/h1")).getText();
        Assert.assertTrue(titleName.equals("About"), "The title on about page isn't correct");
        logger.info("Goes on \"About\" page successfully");
    }

    public void clickOnEvents() {
        driver.findElement(By.xpath("//a[@class=\"in-page-navigation__title\" and contains(text(),\"Events\")]")).click();
    }

    public void verifyEventBtn() {
        String titleName = driver.findElement(By.xpath("//div[@class=\"title\"]/h1")).getText();
        Assert.assertTrue(titleName.equals("Events"), "The title on events page isn't correct");
        logger.info("Goes on \"Events\" page successfully");
    }

    public void clickOnPastEvents() {
        driver.findElement(By.xpath("//li[@class=\"tabs__title\"]/a[contains(text(),\"Past Events\")]")).click();
    }

    public void verifyPastEventsBtn() {
        String className = driver.findElement(By.xpath("//a[@class=\"tabs__link js-tabs-link active\"]")).getAttribute("aria-selected");
        Assert.assertTrue(className.equals("true"), "The title on past events page isn't correct");
        logger.info("Goes on \"PastEvents\" page successfully");
    }

    public void clickOnLearnMore() {
        driver.findElement(By.xpath("//span[@class=\"button__content\" and contains(text(),\"Learn more\")]")).click();
    }

    public void ifExistFacebookBtn() {
        driver.findElement(By.xpath("//button[@data-type=\"fb\"]")).isDisplayed();
    }

    public void verifyFacebookBtn() {
        String className = driver.findElement(By.xpath("//button[@data-type=\"fb\"]")).getAttribute("data-title");
        Assert.assertTrue(className.equals("POST"), "The label on facebook button isn't correct");
        logger.info("Facebook button is correct with label " + className);
    }

    public void waitElementByTime(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
