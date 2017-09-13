package com.software;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @org.junit.Test
    public void test () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Milan\\IdeaProjects\\Project\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.name("search")).sendKeys("Silver");
        driver.findElement(By.name("go")).click();
        String searchHeader = driver.findElement(By.id("firstHeading")).getText();
        Assert.assertTrue(searchHeader.contains("Silver"));

        driver.close();
        driver.quit();
    }
}
