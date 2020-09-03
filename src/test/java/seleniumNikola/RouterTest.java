package seleniumNikola;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;

public class RouterTest {
    private Actions builder;
    private WebDriver browser;


    public void setUp() {
        // instantiate chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        browser = new ChromeDriver();
        builder = new Actions(browser);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.manage().window().maximize();

        //navigate
        browser.navigate().to("http://localhost:4200");

    }

    @Test
    public void test2() {
        setUp();
        WebElement element = this.browser.findElement(By.xpath("//*[@id=\"email\"]"));
        assertNotNull(element);
        element.sendKeys("marko@gmail.com");
        WebElement element2 = this.browser.findElement(By.xpath("//*[@id=\"password\"]"));
        element2.sendKeys("123456");
        WebElement button = this.browser.findElement(By.xpath("//*[@id=\"lekar\"]"));
        button.click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button2 = this.browser.findElement(By.xpath("//*[@id=\"login-box\"]/div/form/div[8]/button"));
        button2.click();
/*
        WebElement element4 = this.browser.findElement(By.id("adresa"));
        //WebElement element2 = this.browser.findElement(By.xpath("//*[@id=\"password\"]"));
        element4.sendKeys("");
        element4.sendKeys("Bulevar Evrope 6.");
        WebElement button3 = this.browser.findElement(By.id("button"));
        button3.click();
        */
    }
    /*
    @AfterMethod
    public void tearDown() {
        browser.close();
    }
    */
}
