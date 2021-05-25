package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DemoTest {

    @Before
    public void startBrowser() {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void demo() {

        String city = "Dublin";

        WebDriver driver = RunEnvironment.getWebDriver();

        //got to google maps website
        driver.get("https://www.google.com/maps");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //dismiss cookies warning
        utils.ButtonClick(driver,"//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[4]/form/div[1]/div/button");

        //search city
        utils.SendKeys(driver,"//*[@id=\"searchboxinput\"]",city);
        utils.ButtonClick(driver,"//*[@id=\"searchbox-searchbutton\"]");

        //search check
        utils.CheckElementText(driver,"//*[@id=\"pane\"]/div/div[1]/div/div/div[2]/div[1]/div[1]/div[1]/h1/span",city);

        //set as destination
        utils.ButtonClick(driver,"//*[@id=\"pane\"]/div/div[1]/div/div/div[4]/div[1]/div/button");

        //check destination value
        utils.CheckInputText(driver,"//*[@id=\"sb_ifc52\"]/input",city);
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
