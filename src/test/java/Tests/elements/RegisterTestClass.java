package Tests.elements;

import BookStoreApplication.Pages.RegisterPage;
import com.codeborne.selenide.Selenide;
import data.RandomDataGenerator;
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


public class RegisterTestClass {
   // private WebDriver driver;
    private RegisterPage registerPage;
    private final static String BASE_URL="https://demoqa.com/register";
    private final static String RANDOM_NAME= RandomDataGenerator.getRandomName();
    private final static String PASSWORD=RandomDataGenerator.getPassword();


    @Before
    public void setUp(){
        open(BASE_URL);
        registerPage=new RegisterPage();
    }

    @Test
    public void fillInFormRegister(){
        registerPage.fillInAccount(RANDOM_NAME, RANDOM_NAME, RANDOM_NAME, PASSWORD);
        //Assert.assertTrue(this.registerPage.checkInvalidField());
    }

    @After
    public void teardown(){
        Selenide.closeWebDriver();
    }

}
