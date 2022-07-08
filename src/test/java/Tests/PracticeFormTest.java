package Tests;

import forms.PracticeForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.Color;

import java.text.ParseException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PracticeFormTest {
    PracticeForm practiceForm;
    Color RED=Color.fromString("#dc3545");

    @Before
    public void setUp(){
        open("https://demoqa.com/automation-practice-form");
        Dimension dimension=new Dimension(700,1000);
        getWebDriver().manage().window().setSize(dimension);
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        practiceForm=new PracticeForm();
    }

    @Test
    public void checkCorrectlyCompletedForm() throws InterruptedException, ParseException {
        practiceForm.fillForm();
        Assert.assertEquals(practiceForm.getDataForm(), practiceForm.getResultTable());
    }
    @Test
    public void checkInvalidCompletedForm() throws InterruptedException, ParseException {
        practiceForm.clickSubmit();
        Thread.sleep(200);
        int count=0;
        for (String str:
             practiceForm.getInvalidBorderInput()) {
            if (str.equals(RED.asRgb())){
                count++;
            }
        }
        Assert.assertTrue(count==7);
    }


}
