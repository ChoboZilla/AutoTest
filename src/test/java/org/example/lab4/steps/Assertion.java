package org.example.lab4.steps;

import io.qameta.allure.Step;
import org.example.lab4.expecteddata.ExpectedData;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Assertion extends StepsInitialization {
    public Assertion(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    @Step("Asserting Browser title")
    public void assertBrowserTitle(String expectedTitle) {
        assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Step("Asserting Username is loggined")
    public void assertUsernameIsLoggined(String expectedUserName) {
        assertEquals(homePage.getUserName(), expectedUserName);
    }

    @Step("Asserting header section items")
    public void assertHeaderSectionItems(int expectedItemsSize, List<String> expectedItemsNames) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(homePage.getHeader().getItemSize(), expectedItemsSize);
        softAssert.assertEquals(homePage.getHeader().getItemsNames(), expectedItemsNames);
        homePage.getHeader().getItemsList().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });

        softAssert.assertAll();
    }

    @Step("Asserting images on the Index Page")
    public void assertIndexPageImages(int expectedImagesSize) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(homePage.getIconsSize(), expectedImagesSize);
        homePage.getIcons().forEach(icon -> {
            softAssert.assertTrue(icon.isDisplayed());
        });

        softAssert.assertAll();
    }

    @Step("Asserting texts on the Index Page under icons")
    public void assertIndexPageTexts(int expectedTextsSize, List<String> expectedTextsStrings) {
        SoftAssert softAssert = new SoftAssert();

        assertEquals(homePage.getIconsTextSize(), expectedTextsSize);
        assertEquals(homePage.getIconsText(), expectedTextsStrings);

        softAssert.assertAll();
    }

    @Step("Asserting iframe existence")
    public void assertFrameExistence() {
        assertTrue(homePage.getFrame().isDisplayed());
    }

    @Step("Asserting Frame Button existence")
    public void assertFrameButtonExistence() {
        assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step("Asserting items on the Left Section and their texts")
    public void assertLeftSectionProperties(int expectedItemsSize, List<String> expectedItemsNames) {
        SoftAssert softAssert = new SoftAssert();

        assertEquals(homePage.getLeftSection().getItemsSize(), expectedItemsSize);
        assertEquals(homePage.getLeftSection().getItemsNames(), expectedItemsNames);
        homePage.getLeftSection().getItemsList().forEach(item -> {
                    assertTrue(item.isDisplayed());
                }
        );

        softAssert.assertAll();
    }

    @Step("Asserting logs")
    public void assertLogs(List<String> expectedLogs) {
        assertEquals(differentElementsPage.getLogs(), expectedLogs);
    }
}
