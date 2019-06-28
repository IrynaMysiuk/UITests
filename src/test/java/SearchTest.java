import com.epam.test.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class SearchTest{
    private FirefoxDriver driver;

    @BeforeTest
    public void initDriver() {
        driver = WebDriverSingleton.getDriver();
    }

    @Test
    public void test1() {
        driver.get("https://www.training.by/");
        WebElement searchBar = driver.findElement(By.xpath("//img[@src=\"/Content/images/BigLogo/2e31172a-1570-488a-a17b-592d6e832435.NET_training.png\"]"));
        searchBar.click();
        WebElement title = driver.findElement(By.xpath("//a[@class='uui-button lime-green button I click register']"));
        //Assert.assertTrue(title.getText().contains("Register"));
        Assert.assertTrue(title.isDisplayed());
        //Assert.assertTrue(title.getText().contains("Зарегистрироваться"));
    }

    @Test
    public void test2() {
        driver.get("http://www.google.com/");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Epam lviv");
        searchBar.click();
        WebElement title = driver.findElement(By.className("LC20lb"));
        Assert.assertTrue(title.getText().contains("EPAM"));
    }

    @Test
    public void testTopButton() {
        driver.get("https://www.epam.com/");
        List<WebElement> buttonList = driver.findElements(By.className("top-navigation__item-link"));
        Assert.assertEquals(buttonList.size(), 6);
    }

    @Test
    public void testSearch() {
        driver.get("https://www.epam.com/");
        WebElement element = driver.findElement(By.className("header-search__button"));
        element.click();
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Lviv");
        WebElement searchButton = driver.findElement(By.className("header-search__submit"));
        searchButton.click();
        List<WebElement> actualListjobs = driver.findElements(By.className("search-results__title-link"));
        Assert.assertEquals(actualListjobs.size(), 8);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
