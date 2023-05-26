package org.example.lab4;

import org.example.lab4.elementspage.DifferentElementsPage;
import org.example.lab4.pages.homepage.HomePage;
import org.example.lab4.steps.Action;
import org.example.lab4.steps.Assertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DriverSetup {
    protected static WebDriver driver;
    protected static Action action;
    protected static Assertion assertion;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("src/test/resources/log-data.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        action = new Action(driver, properties);
        assertion = new Assertion(driver, properties);

        // 1. Open test site by URL
        action.navigateToSite();

        // 3. Perform login
        action.login();
    }

    @AfterTest
    public static void quit() {
        driver.close();
    }

    public static void main(String[] args) {
        setup();
    }
}

