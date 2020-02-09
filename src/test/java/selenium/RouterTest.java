package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;


public class RouterTest {
    private  Actions builder;
    private WebDriver browser;


    @BeforeMethod
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
    public void Test1(){
        WebElement element = this.browser.findElement(By.xpath("//*[@id=\"email\"]"));
        assertNotNull(element);
        element.sendKeys("perakc@uns.ac.rs");
        WebElement element2 = this.browser.findElement(By.xpath("//*[@id=\"password\"]"));
        element2.sendKeys("123456");
        WebElement button = this.browser.findElement(By.xpath("//*[@id=\"administratorKlinickog\"]"));
        button.click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button2 = this.browser.findElement(By.xpath("//*[@id=\"login-box\"]/div/form/div[8]/button"));
        button2.click();

        WebElement old = this.browser.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/input"));
        assertNotNull(element);
        old.sendKeys("123456");
        WebElement novi = this.browser.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[2]/input"));
        novi.sendKeys("1234");
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement dugme = this.browser.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[3]/button"));
        dugme.click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement side = this.browser.findElement(By.xpath("/html/body/app-root/app-admin-kc-layout/div/div[1]/app-sidebar/div[2]/ul/li[1]/a/p"));
        side.click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement dodaj = this.browser.findElement(By.xpath("/html/body/app-root/app-admin-kc-layout/div/div[2]/app-reg-kliniku/div[2]/div/div/div/div[2]/button"));
        dodaj.click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement naziv = this.browser.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/input"));
        assertNotNull(element);
        naziv.sendKeys("VMA");
        WebElement grad = this.browser.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[2]/input"));
        grad.sendKeys("Beograd");
        WebElement dod = this.browser.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[3]/button"));
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dod.click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        browser.close();
    }
}
