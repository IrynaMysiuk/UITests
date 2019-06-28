import com.epam.test.driver.WebDriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLvivPolytechnic {

    private FirefoxDriver driver;
    final static Logger logger = LogManager.getLogger(TestPastEvents.class);

    @BeforeTest
    public void initDriver() {
        driver = WebDriverSingleton.getDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchingLvivPolitechnic() {
        inputTextInGoogle("Lviv Polytechnic");
        waitElementByTime(60);
        clickOnFirstURL();
        inputInSearchBar("epam");
        verifyWordInText();
    }

    public void inputTextInGoogle(String text) {
        WebElement googleInput = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        googleInput.sendKeys(text);
        googleInput.submit();
        logger.info("Input text");
    }

    public void clickOnFirstURL() {
        WebElement firstReference = driver.findElement(By.xpath("//div[@class=\"r\"]/a"));
        firstReference.click();
    }

    public void inputInSearchBar(String text) {
        WebElement lpInput = driver.findElement(By.id("edit-search-block-form--2"));
        lpInput.sendKeys(text);
        lpInput.submit();
    }

    public void verifyWordInText() {
        WebElement firstText = driver.findElement(By.xpath("//li[@class=\"search-result\"]/h3/a"));
        String firstReference = firstText.getText();
        Assert.assertTrue(firstReference.contains("EPAM"), "The first post isn't contains word \"EPAM\"");
    }

    public void waitElementByTime(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
