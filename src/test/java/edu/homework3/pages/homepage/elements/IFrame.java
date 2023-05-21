package edu.homework3.pages.homepage.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFrame {
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IFrame(WebDriver driver) {
        driver.switchTo().frame("frame");
        PageFactory.initElements(driver, this);
    }

    public WebElement getFrameButton() {
        return frameButton;
    }
}
