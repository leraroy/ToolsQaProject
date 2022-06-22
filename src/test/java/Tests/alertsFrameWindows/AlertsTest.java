package Tests.alertsFrameWindows;

import alertsFrameWindows.Alerts;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Lera on 17.06.2022
 */
public class AlertsTest {
    private WebDriver driver;
    private Alerts alerts;
    private final static String BASE_URL="https://demoqa.com/alerts";

   @Before
    public void setUp(){
       WebDriverManager.chromedriver().setup();
       DesiredCapabilities dc = new DesiredCapabilities();
       dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
       driver= new ChromeDriver(dc);
       open(BASE_URL);
       alerts=new Alerts();
    }

    @Test
    public void checkSimpleAlert(){
        alerts.clickButtonAlert();

    }

    @Test
    public void checkAfterSecondsAlert(){
        String expected_result="This alert appeared after 5 seconds";
        String actual_result=alerts.clickAfterSeconds();
        Assert.assertTrue(expected_result.equals(actual_result));
    }

    @Test
    public void checkConfirmAlert(){
        String result="You selected Ok";
        alerts.clickConfirm();
        Assert.assertEquals(result,alerts.getResultConfirm());
    }

    @Test
    public void checkPromptAlert(){
        String result="You entered "+alerts.getNAME();
        alerts.clickPrompt();
        Assert.assertEquals(result, alerts.getResultPrompt());
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
