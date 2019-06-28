package com.epam.test.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class WebDriverSingleton {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    static WebDriver instance;

    public static FirefoxDriver getDriver() {
        if (webDriverThreadLocal.get() != null) {
            return (FirefoxDriver) webDriverThreadLocal.get();
        }
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        instance = new FirefoxDriver() {
            {
                manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//                manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            }
        };
        webDriverThreadLocal.set(instance);
        return (FirefoxDriver) webDriverThreadLocal.get();
    }


}

