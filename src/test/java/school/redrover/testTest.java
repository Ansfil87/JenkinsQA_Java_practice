package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.pages.HomePage;

import static java.sql.DriverManager.getDriver;


public class testTest extends BaseTest {

    private static final String NEW_ITEM = "NewItem";

    //new HomePage(getDriver())
    @Test
public void testTest() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[normalize-space()='New Item']]"))).click();
        getDriver().findElement(By.id("name")).sendKeys(NEW_ITEM);
        getDriver().findElement(By.xpath("//li[@class='com_cloudbees_hudson_plugins_folder_Folder']")).click();
        getWait5().until(ExpectedConditions.elementToBeClickable(By.id("ok-button"))).click();
        getWait5().until(ExpectedConditions.elementToBeClickable(By.name("Submit"))).click();

    }
}
