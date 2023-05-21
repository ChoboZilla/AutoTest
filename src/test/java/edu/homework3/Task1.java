package edu.homework3;

import edu.homework3.expected.Data;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task1 extends WebDriverSetup {
    @Test
    public void testTask1() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(homePage.getTitle(), Data.SITE_NAME);

        // 4. Assert Username is loggined
        softAssert.assertEquals(homePage.getLoggedName(), Data.LOGGED_USER_NAME);

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softAssert.assertEquals(homePage.getHeaderSection().getItemsSize(), Data.HEADER_SECTION_ITEMS_SIZE);
        softAssert.assertEquals(homePage.getHeaderSection().getItemsNames(), Data.HEADER_SECTION_ITEMS_NAMES);

        homePage.getHeaderSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softAssert.assertEquals(homePage.getBenefitIconsSize(), Data.BENEFIT_ICONS_SIZE);

        homePage.getBenefitIcons().forEach(icon -> {
            softAssert.assertTrue(icon.isDisplayed());
        });

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertEquals(homePage.getBenefitIconsTextsSize(), Data.BENEFIT_ICONS_TEXTS_SIZE);
        softAssert.assertEquals(homePage.getBenefitIconsTextsStrings(), Data.BENEFIT_ICONS_TEXTS_STRINGS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.getFrame().isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());

        // 10. Switch to original window back
        homePage.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softAssert.assertEquals(homePage.getLeftSection().getItemsSize(), Data.LEFT_SECTION_ITEMS_SIZE);

        homePage.getLeftSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });

        softAssert.assertEquals(homePage.getLeftSection().getItemsNames(), Data.LEFT_SECTION_ITEMS_NAMES);

        softAssert.assertAll();
    }
}
