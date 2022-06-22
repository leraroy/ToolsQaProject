package Tests.elements;

import com.codeborne.selenide.Selenide;
import elements.TextBox;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Lera on 07.06.2022
 */
public class TextBoxTest {
   // private WebDriver driver;
    private TextBox textBox;
    private final static String BASE_URL="https://demoqa.com/text-box";
    private final static Color COLOR_RED=Color.fromString("red");

    @Before
    public void setUp(){
        open(BASE_URL);
        textBox=new TextBox();
    }

    @Test
    public void fillTextBox(){
        textBox.fillTextBox();
        System.out.println(textBox.outputIsDisplayed());
        Assert.assertTrue(textBox.outputIsDisplayed());
    }

    @Test
    public void checkFailTextBox(){
        textBox.failFillTextBox();
        Assert.assertTrue(textBox.emailFieldError().equals(COLOR_RED.asRgba()));
    }

    @Test
    public void checkRightOutput(){
        fillTextBox();
        List<String> output=textBox.outputTextBox();
        List<String> textbox=new ArrayList<>();
        textbox.add(textBox.getNAME());
        textbox.add(textBox.getEMAIL());
        textbox.add(textBox.getCurrentAddress());
        textbox.add(textBox.getPermanentAddress());

        Assert.assertEquals(textbox,output);
    }
    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
