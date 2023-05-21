package edu.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebDriverSetup {
    protected static WebDriver webDriver;

    @BeforeTest
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();

        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 3. Perform login

        webDriver.findElements(By.className("dropdown-toggle")).get(1).click();

        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
    }

    @Test
    static void generalTests() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        // 4. Assert Username is loggined
        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
    }

    @AfterTest
    public void close() {
        webDriver.close();
    }

}
