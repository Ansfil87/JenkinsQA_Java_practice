package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.pages.FolderConfigurationPage;
import school.redrover.pages.HomePage;

import static java.sql.DriverManager.getDriver;


public class testTest extends BaseTest {

    private static final String FOLDER_NAME = "My Folder";
    private static final String NEW_ITEM = "NewItem";
    private final By newItem = By.xpath("//a[.//span[normalize-space()='New Item']]");
    private final By item = By.cssSelector(".jenkins-table__link > span:first-child");
    private final By nameField = By.id("name");
    private final By folderType = By.cssSelector(".com_cloudbees_hudson_plugins_folder_Folder");
    private final By submitButton = By.name("Submit");
    private final By jenkinsLogo = By.xpath("//a[@class='app-jenkins-logo']");
    private final By descriptionField = By.xpath("//textarea[@name='_.description']");

    //new HomePage(getDriver())
@Test
public void testTest() {

    getWait5().until(ExpectedConditions.elementToBeClickable(newItem)).click();
    getDriver().findElement(nameField).sendKeys(FOLDER_NAME);
    getDriver().findElement(folderType).click();
    getWait5().until(ExpectedConditions.elementToBeClickable(By.id("ok-button"))).click();
    getDriver().findElement(By.xpath("//input[@name='_.displayNameOrNull']")).sendKeys(NEW_ITEM);
    getDriver().findElement(By.xpath("//textarea[@name='_.description']")).sendKeys("Description");
    getWait5().until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    getWait5().until(ExpectedConditions.not(ExpectedConditions.urlContains("/configure")));
    getDriver().findElement(jenkinsLogo).click();
    getWait5().until(ExpectedConditions.elementToBeClickable(By.linkText("NewItem"))).click();
   // getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/configure')]"))).click();
//    getDriver().findElement(descriptionField).clear();
//    getDriver().findElement(By.name("Apply")).click();
//    getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("notification-bar")));

    getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/confirm-rename')]"))).click();
    getDriver().findElement(By.name("newName")).click();
    getDriver().findElement(By.name("Submit")).click();





    }
}
