package edu.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Task1 extends WebDriverSetup {
    @Test
    public void execute() {
        SoftAssert softAssert = new SoftAssert();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItems = webDriver.findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8"))
                                        .findElements(By.xpath("./child::*"));
        softAssert.assertEquals(headerItems.size(), 4);

        String[] names = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        for (int i = 0; i < headerItems.size(); i++) {
            softAssert.assertEquals(headerItems.get(i).getText(), names[i]);
            softAssert.assertTrue(headerItems.get(i).isDisplayed());
        }
        
        //6.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = webDriver.findElements(By.className("benefit-icon"));

        softAssert.assertEquals(images.size(), 4);

        for (WebElement image: images) {
            softAssert.assertTrue(image.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedTexts = {
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
        };

        List<WebElement> texts = webDriver.findElements(By.className("benefit-txt"));

        softAssert.assertEquals(texts.size(), 4);

        for (int i = 0; i < texts.size(); i++) {
            softAssert.assertEquals(texts.get(i).getText(), expectedTexts[i]);
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertEquals(webDriver.findElement(By.tagName("iframe")).getAttribute("src"),
                                    "https://jdi-testing.github.io/jdi-light/frame-button.html");

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(webDriver.findElement(By.tagName("iframe")));
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> leftSectionItems = webDriver.findElement(By.cssSelector("ul.sidebar-menu.left"))
                .findElements(By.xpath("./child::*"));
        softAssert.assertEquals(leftSectionItems.size(), 5);

        String[] items = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

        for (int i = 0; i < leftSectionItems.size(); i++) {
            softAssert.assertEquals(leftSectionItems.get(i).getText(), items[i]);
            softAssert.assertTrue(leftSectionItems.get(i).isDisplayed());
        }

        softAssert.assertAll();
    }
}
