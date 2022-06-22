package Tests.elements;

import com.codeborne.selenide.Selenide;
import elements.DynamicProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Lera on 13.06.2022
 */
public class DynamicPropertiesTest {
   // private WebDriver driver;
    private DynamicProperties dynamicProperties;
    private final static String BASE_URL="https://demoqa.com/";
    private static Color RED_COLOR  = Color.fromString("rgba(220, 53, 69, 1)");

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
       open(BASE_URL+"dynamic-properties");
        dynamicProperties=new DynamicProperties();
    }

    @Test
    public void checkClickEnableButton(){
        dynamicProperties.clickEnable();
        Assert.assertTrue(dynamicProperties.getEnableButton().isEnabled());
    }

    @Test
    public void checkClickColorButton(){
        dynamicProperties.clickColorChangeButton();
        Assert.assertTrue(dynamicProperties.getColorChangeButton().getCssValue("color").equals(RED_COLOR.asRgba()));
    }

    @Test
    public void checkClickVisibleButton(){
        Assert.assertTrue(dynamicProperties.clickVisible());
    }


    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}


