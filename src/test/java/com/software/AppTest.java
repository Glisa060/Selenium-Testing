package com.software;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    final static Logger logger = Logger.getLogger(AppTest.class);
    private final String FILE = "C:\\Users\\Milan\\IdeaProjects\\Selenium Testing\\src\\chromedriver.exe";
    private final String DRIVER = "webdriver.chrome.driver";
    @org.junit.Test
    public void test () {
        System.setProperty(DRIVER,FILE);
        WebDriver driver = new ChromeDriver();
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
        if (logger.isDebugEnabled()) {
            logger.debug("This is a debug message: ");
        }
        driver.close();
    }

    @org.junit.Test
    public void test2() {
        System.setProperty(DRIVER, FILE);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.echoecho.com/htmlforms10.htm");
        driver.manage().window().maximize();
        List<WebElement> list = driver.findElements(By.name("radio1"));
        System.out.println("Number of radio buttons is " + list.size());
        for (WebElement e: list
             ) {
            e.getAttribute("value");
            System.out.println(e.isSelected());
            if (e.getAttribute("value").equals("Butter")) {
                e.click();
                break;
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("This is a debug message: ");
        }
        driver.close();
    }

    @org.junit.Test
    public void test3() {
        System.setProperty(DRIVER,FILE);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://jqueryui.com/draggable/");
        driver.manage().window().maximize();
        List<WebElement> list = driver.findElements(By.tagName("iframe"));
        System.out.println("The number of frames is: " +list.size());
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        System.out.println(element.getText());
        driver.switchTo().defaultContent();
        WebElement Pageheader = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        System.out.println("Header text is: " +Pageheader.getText());
        if (logger.isDebugEnabled()) {
            logger.debug("This is a debug message: ");
        }
        driver.close();
    }

    @org.junit.Test
    public void test4() {
        System.setProperty(DRIVER,FILE);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/css/css_dropdowns.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/div/button")));
       select.selectByVisibleText("Link 1");
        if (logger.isDebugEnabled()) {
            logger.debug("This is a debug message: ");
        }
       driver.close();
       driver.quit();
    }
}
