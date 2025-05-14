package org.zzy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {
    private WebDriver driver = null;

    @BeforeMethod
    protected void setUp() {
        driver = WebDriverManager.getInstance(DriverManagerType.CHROME).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://habr.com/en/feed");
    }

    @Test(enabled = false)
    public void somePassedTest() {
        String actualHeader = driver.findElements(By.xpath("//div[contains(@class, 'my-feed-page') and contains(@class, 'header')]//h1")).getFirst().getText();
        Assert.assertEquals(actualHeader, "My feed", "Header isn't equal to expected");
    }

    @Test(enabled = false)
    public void someFailedTest() {
        String actualHeader = driver.findElements(By.xpath("//div[contains(@class, 'my-feed-page') and contains(@class, 'header')]//h1")).getFirst().getText();
        Assert.assertEquals(actualHeader, "My incorrect feed", "Header isn't equal to expected");
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
