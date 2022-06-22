package Tests.elements;

import com.codeborne.selenide.Selenide;
import elements.Links;
import elements.TextBox;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;


public class LinksTest {
    //private WebDriver driver;
    private final static String BASE_URL="https://demoqa.com/";
    private Links links;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        open(BASE_URL+"links");
        links=new Links();
    }


    @Test
    public void checkHomeFirstOpenNewTab(){
        links.clickHomeFirst();
        String currentUrl=links.getHomeUrl();
        Assert.assertEquals(BASE_URL,currentUrl);
    }
    @Test
    public void checkHomeSecondOpenNewTab(){
        links.clickHomeSecond();
        String currentUrl=links.getHomeUrl();
        Assert.assertEquals(BASE_URL,currentUrl);
    }
    @Test
    public void clickableLinksApi(){
        Assert.assertEquals(true,links.clickableLinksApi());
    }
    @Test
    public void checkStatusCreated(){
        int status=links.getStatus(BASE_URL,"created");
        Assert.assertEquals(201, status);
    }
    @Test
    public void checkTextResponseCreated(){
        links.clickCreated();
        String expected=links.getTextByStatus("Created");
        System.out.println(expected);
        String actual=links.getTextResponse();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void checkStatusNoContent(){
        int status=links.getStatus(BASE_URL, "no-content");
        Assert.assertEquals(204, status);
    }
    @Test
    public void checkTextResponseNoContent(){
        links.clickNoContent();
        String expected=links.getTextByStatus("No Content");
        System.out.println(expected);
        String actual=links.getTextResponse();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void checkTextResponseMoved(){
        links.clickMoved();
        String expected=links.getTextByStatus("Moved");
        System.out.println(expected);
        String actual=links.getTextResponse();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void checkStatusBadRequest(){
        int status=links.getStatus(BASE_URL, "bad-request");
        Assert.assertEquals(400,status);
    }
    @Test
    public void checkTextResponseBadRequest(){
        links.clickBadRequest();
        String expected=links.getTextByStatus("Bad Request");
        System.out.println(expected);
        String actual=links.getTextResponse();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkStatusUnauthorized(){
        int status=links.getStatus(BASE_URL, "unauthorized");
        Assert.assertEquals(401,status);
    }

    @Test
    public void checkTextResponseUnauthorized(){
        links.clickUnauthorized();
        String expected=links.getTextByStatus("Unauthorized");
        System.out.println(expected);
        String actual=links.getTextResponse();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkStatusForbidden(){
        int status= links.getStatus(BASE_URL, "forbidden");
        Assert.assertEquals(403,status);
    }
    @Test
    public void checkTextResponseForbidden(){
        links.clickForbidden();
        String expected=links.getTextByStatus("Forbidden");
        System.out.println(expected);
        String actual=links.getTextResponse();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void checkStatusNotFound(){
        int status= links.getStatus(BASE_URL, "invalid-url");
        Assert.assertEquals(404, status);
    }

    @Test
    public void checkTextResponseNoFound(){
        links.clickNotFound();
        String expected=links.getTextByStatus("Not Found");
        System.out.println(expected);
        String actual=links.getTextResponse();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

  /*  @Test
    public void checkStatusMoved(){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.get("moved");
        Assert.assertEquals(response.getStatusCode(), 301);
    }
   */

}
