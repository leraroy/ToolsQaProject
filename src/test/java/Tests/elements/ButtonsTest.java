package Tests.elements;

import com.codeborne.selenide.Selenide;
import elements.Buttons;
import elements.TextBox;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;


public class ButtonsTest {

    private Buttons buttons;
    private final String BASE_URL="https://demoqa.com/buttons";

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        open(BASE_URL);
        buttons=new Buttons();
    }

    @Test
    public void checkDoubleClick(){
        String text="You have done a double click";
        buttons.clickDoubleClick();
        Assert.assertEquals(text, buttons.getMessageDoubleClick());
    }

    @Test
    public void checkRightClick(){
        String text="You have done a right click";
        buttons.clickRightClick();
        Assert.assertEquals(text, buttons.getMessageRightClick());
    }

    @Test
    public void checkClickMe(){
        String text="You have done a dynamic click";
        buttons.clickMe();
        Assert.assertEquals(text, buttons.getMessageClickMe());
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
