package org.example.lab4.steps;

import io.qameta.allure.Step;
import org.example.lab4.elementspage.DifferentElementsPage;
import org.example.lab4.pages.homepage.HomePage;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Action extends StepsInitialization {
    public Action(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    @Step("Navigating to site")
    public void navigateToSite() {
        homePage = new HomePage(driver, properties);
    }

    @Step("Performing login")
    public void login() {
        homePage.performLogin();
    }

    @Step("Switching to the default window")
    public void switchToDefault() {
        homePage.switchToDefault();
    }


    @Step("Opening Different Elements Page")
    public void openDifferentElementsPage() {
        homePage.getHeader().clickServiceDropDown();
        homePage.getHeader().clickDifferentElements();
    }

    @Step("Navigating to Different Elements Page")
    public void navigateToDifferentElementsPage() {
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Selecting Water and Wind checkboxes on Different Elements Page")
    public void selectCheckBoxes(String checkBox1Name, String checkBox2Name) {
        differentElementsPage.SelectCheckBox(checkBox1Name);
        differentElementsPage.SelectCheckBox(checkBox2Name);
    }

    @Step("Selecting Selen radio on Different Elements Page")
    public void selectRadio(String radioName) {
        differentElementsPage.SelectRadio(radioName);
    }

    @Step("Selecting Yellow in dropdown on Different Elements Page")
    public void selectInDropdown(String dropdownItemName) {
        differentElementsPage.SelectInDropdown(dropdownItemName);
    }
}
