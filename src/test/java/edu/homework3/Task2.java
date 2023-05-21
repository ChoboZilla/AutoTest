package edu.homework3;

import edu.homework3.expected.Data;
import edu.homework3.pages.differnetelementspage.DifferentElementsPage;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task2 extends WebDriverSetup {
    @Test
    public void testBrowserTitle() {
        // 2. Assert browser title
        assertEquals(homePage.getTitle(), Data.SITE_NAME);
    }

    @Test
    public void testLogin() {
        // 4. Assert Username is loggined
        assertEquals(homePage.getLoggedName(), Data.LOGGED_USER_NAME);
    }

    @Test
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver, homePage);

        // 6. Select checkboxes
        differentElementsPage.selectCheckbox("Water");
        differentElementsPage.selectCheckbox("Wind");

        // 7. Select radio
        differentElementsPage.selectRadio("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectDropdownOption("Yellow");

        // 9. Assert logs
        assertEquals(differentElementsPage.getLogs(), Data.DIFFERENT_ELEMENTS_LOGS);
    }
}