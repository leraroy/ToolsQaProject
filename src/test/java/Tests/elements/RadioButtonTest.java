package Tests.elements;

import com.codeborne.selenide.Selenide;
import elements.RadioButton;
import elements.TextBox;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Lera on 07.06.2022
 */
public class RadioButtonTest {
    //private WebDriver driver;
    private RadioButton radioButton;
    private final static String BASE_URL="https://demoqa.com/radio-button";

    @Before
    public void setUp(){
        open(BASE_URL);
        radioButton=new RadioButton();
    }

    @Test
    public void checkYesButton(){
        String expected="You have selected Yes";
        radioButton.clickYes();
        System.out.println(expected);
        Assert.assertEquals(expected,radioButton.getTextResult());
    }

    @Test
    public void checkImpressiveButton(){
        String expected="You have selected Impressive";
        radioButton.clickImpressive();
        System.out.println(expected);
        Assert.assertEquals(expected,radioButton.getTextResult());
    }

    @Test
    public void checkNoButton(){
        radioButton.clickNo();
        Assert.assertEquals(false, radioButton.clickNoIsSelected());
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
