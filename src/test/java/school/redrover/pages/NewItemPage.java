package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewItemPage extends BasePage {

    private final By nameField = By.id("name");
    private final By folderType = By.cssSelector(".com_cloudbees_hudson_plugins_folder_Folder");

    public NewItemPage(WebDriver driver) {
        super(driver);
    }

    public NewItemPage sendName(String itemName) {
        getDriver().findElement(nameField).sendKeys(itemName);

        return this;
    }

    public NewItemPage selectFolder() {
        getDriver().findElement(folderType).click();

        return this;
    }

    public <T extends BasePage> T clickOk(T nextPage) {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.id("ok-button"))).click();

        return nextPage;
    }
}
