package Tests.alertsFrameWindows;

import alertsFrameWindows.BrowserWindows;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class BrowserWindowsTest {
   // private WebDriver driver;
    private BrowserWindows browserWindows;
    private final String BASE_URL="https://demoqa.com/browser-windows";

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        open(BASE_URL);
        browserWindows=new BrowserWindows();
    }

    @Test
    public void checkNewTab(){
        browserWindows.clickNewTab();
        Assert.assertTrue(browserWindows.checkWindowsOrTab().equals("https://demoqa.com/sample"));
    }

    @Test
    public void checkNewWindow(){
        browserWindows.clickNewWindow();
        Assert.assertTrue(browserWindows.checkWindowsOrTab().equals("https://demoqa.com/sample"));
    }
    @Test
    public void checkNewWindowMessage(){
        browserWindows.clickNewWindowMessage();
        Assert.assertTrue(browserWindows.countWindows().equals(2));
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

}
