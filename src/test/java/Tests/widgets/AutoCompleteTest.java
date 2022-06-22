package Tests.widgets;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Colors;
import widgets.AutoComplete;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Lera on 20.06.2022
 */
public class AutoCompleteTest {
    private WebDriver driver;
    AutoComplete autoComplete;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/auto-complete");
        autoComplete=new AutoComplete(driver);
    }

    @Test
    public void checkTypeMultiplyColorNames(){
        autoComplete.typeMultipleColor("r");
        autoComplete.autoSuggest();
        autoComplete.clickColor(Colors.RED.name());
        Assert.assertTrue(autoComplete.getTextResultMultiply().equalsIgnoreCase(Colors.RED.name()));
    }

    @Test
    public void checkTypeMultiplyColors(){
        autoComplete.typeMultipleColor("a");
        String expected_result=autoComplete.autoSuggestText();
        autoComplete.clickColorsMultiple("a");
        String actual_result=autoComplete.getTextResultMultiply();
        Assert.assertTrue(expected_result.equals(actual_result));
    }

    @Test
    public void checkTypeSingleColor(){
        autoComplete.typeSingleColor("b");
        autoComplete.autoSuggest();
        autoComplete.clickColor(Colors.BLACK.name());
        Assert.assertTrue(autoComplete.getTextResultSingle().equalsIgnoreCase(Colors.BLACK.name()));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
