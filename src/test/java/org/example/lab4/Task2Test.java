package org.example.lab4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.example.lab4.expecteddata.ExpectedData;
import org.testng.annotations.Test;

@Feature("Second task on testing by steps")
public class Task2Test extends DriverSetup {
    @Test(priority = 1)
    @Story("Testing Home Page Title")
    public void testHomePageTitle() {
        //2. Assert Browser title
        assertion.assertBrowserTitle(ExpectedData.SITE_NAME);
    }

    @Test(priority = 2)
    @Story("Testing that it is loggined")
    public void testIsLoggined() {
        // 4. Assert Username is loggined
        assertion.assertUsernameIsLoggined(ExpectedData.USERNAME);
    }

    @Test(priority = 3)
    @Story("Testing elements on Different Element Page")
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        action.openDifferentElementsPage();

        action.navigateToDifferentElementsPage();

        // 6. Select checkboxes
        action.selectCheckBoxes("Water", "Wind");

        // 7. Select radio
        action.selectRadio("Selen");

        // 8. Select in dropdown
        action.selectInDropdown("Yellow");

        // 9. Assert logs
        assertion.assertLogs(ExpectedData.LOGS);
    }
}
