package org.example.lab4.pages.homepage;

import org.example.lab4.pages.homepage.elements.Header;
import org.example.lab4.pages.homepage.elements.IFrame;
import org.example.lab4.pages.homepage.elements.LeftSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class HomePage {
    protected static WebDriver driver;
    protected static Properties properties;

    private Header header;

    private LeftSection leftSection;
    @FindBy(css = "body > header > div > nav > ul.uui-navigation.navbar-nav.navbar-right > li > a > span")
    private WebElement loginDropDownButton;

    @FindBy(id = "name")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "benefit-icon")
    private List<WebElement> icons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> iconsText;

    @FindBy(tagName = "iframe")
    private WebElement frame;

    public HomePage(WebDriver driver, Properties properties) {
        HomePage.driver = driver;

        HomePage.properties = properties;

        this.header = new Header(this.driver);

        this.leftSection = new LeftSection(this.driver);

        driver.navigate().to(properties.getProperty("site.url"));

        PageFactory.initElements(this.driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserName() {
        return userName.getText();
    }

    public Header getHeader() {
        return header;
    }

    public void performLogin() {
        loginDropDownButton.click();
        login.sendKeys(properties.getProperty("user.login"));
        password.sendKeys(properties.getProperty("user.password"));
        loginButton.click();
    }

    public List<WebElement> getIcons() {
        return icons;
    }

    public int getIconsSize() {
        return icons.size();
    }

    public List<String> getIconsText() {
        return iconsText.stream().map(WebElement::getText).toList();
    }

    public int getIconsTextSize() {
        return iconsText.size();
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return new IFrame(driver).getFrameButton();
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public LeftSection getLeftSection() {
        return leftSection;
    }
}
