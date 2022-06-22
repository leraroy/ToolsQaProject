package Tests.elements;

import com.codeborne.selenide.Selenide;
import elements.BrokenLinks;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BrokenLinksTest {
    //private WebDriver driver;
    private static BrokenLinks brokenLinks;
    private final static String BASE_URL="https://demoqa.com/";

    @BeforeClass
    public static void url(){
        open(BASE_URL+"broken");
        brokenLinks=new BrokenLinks();
    }

    @Test
    public void checkValidImage(){
       int count= brokenLinks.getAllValidImage();
        Assert.assertTrue(count>1);
    }
    @Test
    public void checkBrokenImage(){
        int count= brokenLinks.getAllBrokenImage();
        System.out.println(count);
        Assert.assertTrue(count==2);
    }
    @Test
    public void checkLink(){
        List<WebElement> links = getWebDriver().findElements(By.tagName("a"));

        System.out.println("No of links are "+ links.size());

        for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            brokenLinks.verifyLinks(url);
        }

    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
