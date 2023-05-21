package edu.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Task2 extends WebDriverSetup {

    @Test
    public void execute() {
        SoftAssert softAssert = new SoftAssert();

        // 5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.className("dropdown-toggle")).click();
        webDriver.findElement(By.className("dropdown-menu")).findElements(By.xpath("./child::*")).get(7).
                                            findElement(By.tagName("a")).click();

        // 6. Select checkboxes
        List<WebElement> checkboxes = webDriver.findElements(By.className("label-checkbox"));
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals("Water") || checkbox.getText().equals("Wind")) {
                checkbox.findElement(By.tagName("input")).click();
            }
        }

        // 7. Select radio
        List<WebElement> radios = webDriver.findElements(By.className("label-radio"));
        for (WebElement radio : radios) {
            if (radio.getText().equals("Selen")) {
                radio.findElement(By.tagName("input")).click();
            }
        }

        // 8. Select in dropdown
        List<WebElement> selectors = webDriver.findElements(By.tagName("option"));
        for (WebElement selector : selectors) {
            if (selector.getText().equals("Yellow")) {
                selector.click();
            }
        }

        // 9. Assert logs
        List<String> logs = webDriver.findElements(By.cssSelector("ul[class='panel-body-list logs'] > li")).stream().map((s) -> s.getText().substring(9)).collect(Collectors.toList());

        String[] realLogs = new String[]{
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        for (int i = 0; i < logs.size(); i++) {
            Assert.assertEquals(logs.get(i), realLogs[i]);
        }

        softAssert.assertAll();
    }
}
