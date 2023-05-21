package edu.homework3.pages.homepage;

import edu.homework3.pages.homepage.elements.Header;
import edu.homework3.pages.homepage.elements.IFrame;
import edu.homework3.pages.homepage.elements.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home {
    private final WebDriver driver;

    private final Header headerSection;
    private final Menu leftSection;

    @FindBy(id = "name")
    private WebElement loginName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "html > body > header > div > nav > ul.uui-navigation.navbar-nav.navbar-right > li > a > span")
    private WebElement loginDropDownButton;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitIconsTexts;

    @FindBy(tagName = "iframe")
    private WebElement frame;

    public Home(WebDriver driver, String url) {
        this.driver = driver;

        // 1. Open test site by URL
        driver.navigate().to(url);

        PageFactory.initElements(this.driver, this);

        headerSection = new Header(driver);
        leftSection = new Menu(driver);
    }

    public void performLogin(String loginName, String password) {
        loginDropDownButton.click();
        this.loginName.sendKeys(loginName);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getLoggedName() {
        return userName.getText();
    }

    public Header getHeaderSection() {
        return headerSection;
    }

    public int getBenefitIconsSize() {
        return benefitIcons.size();
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public int getBenefitIconsTextsSize() {
        return benefitIconsTexts.size();
    }

    public List<String> getBenefitIconsTextsStrings() {
        return benefitIconsTexts.stream().map(WebElement::getText).toList();
    }

    public Menu getLeftSection() {
        return leftSection;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return new IFrame(driver).getFrameButton();
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}
