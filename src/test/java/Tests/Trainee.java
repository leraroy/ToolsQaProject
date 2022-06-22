package Tests;

import alertsFrameWindows.ModalDialogs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import widgets.Accordian;
import widgets.AutoComplete;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.files.DownloadActions.click;
import static io.restassured.RestAssured.given;

/**
 * Created by Lera on 03.06.2022
 */
public class Trainee {
    private static WebDriver driver;
    private static AutoComplete autoComplete;

    private final static String BASE_URL="https://demoqa.com/auto-complete";
    private final static String URL="https://demoqa.com/";


    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
      //  Dimension dimension = new Dimension(700, 1080);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(BASE_URL);

        autoComplete=new AutoComplete(driver);
        autoComplete.typeSingleColor("b");
        System.out.println(driver.getPageSource());

/*
        autoComplete.typeMultipleColor("r");
        autoComplete.autoSuggest();
        autoComplete.clickColor(Color.red.toString());


 */
       // driver.quit();
    }


    }

