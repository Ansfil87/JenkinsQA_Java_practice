package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.pages.FolderConfigurationPage;
import school.redrover.pages.HomePage;

public class FolderTest extends BaseTest {

    private static final String FOLDER_NAME = "My Folder";

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
}
