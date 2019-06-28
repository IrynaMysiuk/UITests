import com.epam.test.driver.WebDriverSingleton;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YoutubeTest  {
    private FirefoxDriver driver;
    @BeforeTest
    public void initDriver() {
        driver = WebDriverSingleton.getDriver();
    }

    @Test
    public void yoububeTest() throws InterruptedException {

        Thread.sleep(5000);
        for(int i=0;i<5000;i++)
        {
            driver.get("https://www.youtube.com/watch?v=LLylzAKQQcw");
            Thread.sleep(8000);
        }

    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
