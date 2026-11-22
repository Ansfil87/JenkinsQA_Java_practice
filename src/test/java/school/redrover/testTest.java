package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.pages.HomePage;

import static java.sql.DriverManager.getDriver;


public class testTest extends BaseTest {

    @Test
public void testTest() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[normalize-space()='New Item']]")));
    }

}
