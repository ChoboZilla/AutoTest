package edu.homework3;

import edu.homework3.pages.homepage.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class WebDriverSetup {
    protected static WebDriver driver;

    protected static Home homePage;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("src/test/resources/data.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new Home(driver, properties.getProperty("site.url"));

        // 3. Perform login
        homePage.performLogin(properties.getProperty("user.name"), properties.getProperty("user.password"));
    }

    @AfterTest
    public static void exit() {
        //10. Close Browser
        driver.close();
    }
}
