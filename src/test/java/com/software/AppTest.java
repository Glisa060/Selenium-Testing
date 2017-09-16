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
        driver.navigate().to("https://www.rt.com/news/");
        driver.manage().window().maximize();
        driver.findElement(By.className("seach-form__input-text")).sendKeys("America");
        driver.findElement(By.className("seach-form__input-submit")).click();
//        String searchHeader = driver.findElement(By.className("w3-center")).getText();
//        Assert.assertTrue(searchHeader.contains(""));
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("Number of links is " +list.size());
        for (int i = 0; i < list.size(); i++ ) {
            if (list.get(i).getText().equals("News")) {
                list.get(i).click();
                break;
            }
        }
        driver.close();
    }

    @org.junit.Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Milan\\IdeaProjects\\Project\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.echoecho.com/htmlforms10.htm");
        driver.manage().window().maximize();
        List<WebElement> list = driver.findElements(By.name("radio1"));
        System.out.println("Number of radio buttons is " + list.size());
        driver.close();
    }
}
