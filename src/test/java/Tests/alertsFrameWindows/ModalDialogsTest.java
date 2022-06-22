package Tests.alertsFrameWindows;

import alertsFrameWindows.ModalDialogs;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;


public class ModalDialogsTest {
   // private WebDriver driver;
    private ModalDialogs modalDialogs;

    private final static String BASE_URL="https://demoqa.com/modal-dialogs";

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        open(BASE_URL);
        modalDialogs=new ModalDialogs();
    }

    @Test
    public void checkSmallModal(){
        String expected="This is a small modal. It has very less content";
        modalDialogs.clickSmallModal();
        String actual=modalDialogs.getTextSmallModal();
        System.out.println(modalDialogs.getTextSmallModal());
        modalDialogs.closeSmallModal();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkLargeModal(){
        modalDialogs.clickLargeModal();
        modalDialogs.getTextLargeModal();
        File expected=new File("src/main/resources/expected/largeModalExpected.txt");
        File actual=new File("src/main/resources/actual.txt");
        System.out.println(expected.length());
        System.out.println(actual.length());
        Assert.assertTrue(modalDialogs.isEqual(expected,actual));
        modalDialogs.closeLargeModal();
    }

    @After
    public void teardown(){
        Selenide.closeWebDriver();
    }
}
