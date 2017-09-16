package com.software;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private final String FILE = "C:\\Users\\Milan\\IdeaProjects\\Selenium Testing\\src\\chromedriver.exe";
    @org.junit.Test
    public void test () {
        System.setProperty("webdriver.chrome.driver", FILE);
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
        for (WebElement aList : list)
            if (aList.getText().equals("News")) {
                aList.click();
                break;
            }
        driver.close();
    }

    @org.junit.Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", FILE);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.echoecho.com/htmlforms10.htm");
        driver.manage().window().maximize();
        List<WebElement> list = driver.findElements(By.name("radio1"));
        System.out.println("Number of radio buttons is " + list.size());
        driver.close();
    }
}
