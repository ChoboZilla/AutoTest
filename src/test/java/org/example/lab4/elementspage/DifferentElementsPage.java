package org.example.lab4.elementspage;

import org.example.lab4.expecteddata.ExpectedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class DifferentElementsPage {
    private static WebDriver driver;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(css = "select[class=uui-form-element] > option")
    private List<WebElement> dropdown;

    @FindBy(css = "ul.panel-body-list.logs")
    private WebElement logs;

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    public void SelectCheckBox(String name) {
        checkboxes.stream().filter(cb -> cb.getText().equals(name)).forEach(WebElement::click);
    }

    public void SelectRadio(String name) {
        radios.stream().filter(r -> r.getText().equals(name)).forEach(WebElement::click);
    }

    public void SelectInDropdown(String name) {
        dropdown.stream().filter(item -> item.getText().equals(name)).forEach(WebElement::click);
    }

    public List<String> getLogs() {
        return Arrays.stream(logs.getText().split("\n"))
                .map(el -> el.substring(ExpectedData.LOGS_START_SYMBOL))
                .toList();
    }
}
