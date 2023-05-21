package edu.homework3.pages.homepage.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Header {
    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> items;

    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li > a > span")
    private WebElement serviceDropDown;

    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(8) > a")
    private WebElement differentElements;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickServiceDropDown() {
        serviceDropDown.click();
    }

    public void clickDifferentElement() {
        differentElements.click();
    }

    public List<WebElement> getItems() {
        return items;
    }

    public int getItemsSize() {
        return items.size();
    }

    public List<String> getItemsNames() {
        return items.stream().map(WebElement::getText).toList();
    }
}
