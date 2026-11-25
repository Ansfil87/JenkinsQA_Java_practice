package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.pages.FolderConfigurationPage;
import school.redrover.pages.FolderStatusPage;
import school.redrover.pages.HomePage;

public class FolderTest extends BaseTest {

    private static final String FOLDER_NAME = "My Folder";
    private static final String DISPLAY_NAME = "My new folder";
    private static final String DESCRIPTION = "My new folder description";
    private static final String NEW_DESCRIPTION = "New description";

    @Test
    public void testCreate() {
        String folderName = new HomePage(getDriver())
                .clickNewItem()
                .sendName(FOLDER_NAME)
                .selectFolder()
                .clickOk(new FolderConfigurationPage(getDriver()))
                .clickSave()
                .goToHomePage()
                .getFirstProjectName();

        Assert.assertEquals(folderName, FOLDER_NAME);
    }

    @Test
    public void testDisplayNameAndDescription() {

        FolderStatusPage folderPage = new HomePage(getDriver())
                .clickNewItem()
                .sendName(FOLDER_NAME)
                .selectFolder()
                .clickOk(new FolderConfigurationPage(getDriver()))
                .sendDisplayName(DISPLAY_NAME)
                .sendDescription(DESCRIPTION)
                .clickSave();

        Assert.assertEquals(folderPage.getHeading(), DISPLAY_NAME);
        Assert.assertEquals(folderPage.getDescription(), DESCRIPTION);
    }

    @Test(dependsOnMethods = "testDisplayNameAndDescription")
    public void testApplyShowsSavedNotification() {

        String notificationText = new HomePage(getDriver())
                .clickFolder(DISPLAY_NAME)
                .clickConfigure()
                .sendDescription(NEW_DESCRIPTION)
                .clickApply()
                .getNotificationText();

        Assert.assertEquals(notificationText, "Saved");
    }
}
