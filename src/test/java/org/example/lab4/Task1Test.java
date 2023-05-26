package org.example.lab4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.example.lab4.expecteddata.ExpectedData;
import org.testng.annotations.Test;

@Feature("First task on testing by steps")
public class Task1Test extends DriverSetup {
    @Test
    @Story("Testing the Home Page")
    public void softAssertTest() {
        //2. Assert Browser title
        assertion.assertBrowserTitle(ExpectedData.SITE_NAME);

        // 4. Assert Username is loggined
        assertion.assertUsernameIsLoggined(ExpectedData.USERNAME);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertion.assertHeaderSectionItems(ExpectedData.HEADER_DATA_SIZE, ExpectedData.HEADER_DATA_NAMES);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        assertion.assertIndexPageImages(ExpectedData.ICONS_SIZE);

        // 7. Assert that there 4 texts on the Index Page under icons, and they have proper text
        assertion.assertIndexPageTexts(ExpectedData.TEXT_UNDER_ICONS_SIZE, ExpectedData.TEXT_UNDER_ICONS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        assertion.assertFrameExistence();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertion.assertFrameButtonExistence();

        // 10. Switch to original window back
        action.switchToDefault();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        assertion.assertLeftSectionProperties(ExpectedData.LEFT_SECTION_ITEMS_SIZE, ExpectedData.LEFT_SECTION_ITEMS_STRINGS);
    }
}
