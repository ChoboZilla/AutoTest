package org.example.lab4.steps;

import org.example.lab4.elementspage.DifferentElementsPage;
import org.example.lab4.pages.homepage.HomePage;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class StepsInitialization {
    protected static WebDriver driver;
    protected static Properties properties;

    public static HomePage homePage;
    protected static DifferentElementsPage differentElementsPage;

    public StepsInitialization(WebDriver driver, Properties properties) {
        StepsInitialization.driver = driver;
        StepsInitialization.properties = properties;
    }
}
