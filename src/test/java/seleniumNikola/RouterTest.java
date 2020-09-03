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
    public void testLogin() {
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

    @Test
    public void testReg() {
        setUp();
        browser.navigate().to("http://localhost:4200/registracija");
        WebElement element = this.browser.findElement(By.xpath("//*[@id=\"ime\"]"));
        assertNotNull(element);
        element.sendKeys("Nikola");
        WebElement element2 = this.browser.findElement(By.xpath("//*[@id=\"prezime\"]"));
        element2.sendKeys("Kekic");
        WebElement element3 = this.browser.findElement(By.xpath("//*[@id=\"email\"]"));
        element3.sendKeys("nikola.get@gmail.com");
        WebElement element4 = this.browser.findElement(By.xpath("//*[@id=\"lozinka\"]"));
        element4.sendKeys("123456");
        WebElement element5 = this.browser.findElement(By.xpath("//*[@id=\"adresa\"]"));
        element5.sendKeys("Bulevar Osl. 72.");
        WebElement element6 = this.browser.findElement(By.xpath("//*[@id=\"grad\"]"));
        element6.sendKeys("NS");
        WebElement element7 = this.browser.findElement(By.xpath("//*[@id=\"drzava\"]"));
        element7.sendKeys("Bulevar Osl. 72.");
        WebElement element8 = this.browser.findElement(By.xpath("//*[@id=\"tel\"]"));
        element8.sendKeys("NS");
        WebElement element9 = this.browser.findElement(By.xpath("//*[@id=\"jbo\"]"));
        element9.sendKeys("Bulevar Osl. 72.");
        WebElement element10 = this.browser.findElement(By.xpath("//*[@id=\"korIme\"]"));
        element10.sendKeys("NS");
        WebElement element11 = this.browser.findElement(By.xpath("//*[@id=\"datum\"]"));
        element11.sendKeys("Bulevar Osl. 72.");


        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button2 = this.browser.findElement(By.xpath("//*[@id=\"reg\"]"));
        button2.click();

    }
    /*
    @AfterMethod
    public void tearDown() {
        browser.close();
    }
    */
}
