package forms;

import data.Options;
import data.RandomDataGenerator;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Lera on 15.06.2022
 */
public class PracticeForm extends Options {
    //private WebDriver driver;
    private PracticeFormData practiceFormData=new PracticeFormData();

    private By firstName=By.xpath("//input[@id='firstName']");
    private By lastName=By.xpath("//input[@id='lastName']");
    private By email=By.xpath("//input[@id='userEmail']");
    private By genderMale=By.xpath("//input[@value='Male']/following-sibling::label");
    private By genderFemale=By.xpath("//input[@value='Female']/following-sibling::label");
    private By genderOther=By.xpath("//input[@value='Other']/following-sibling::label");
    private By mobile=By.xpath("//input[@id='userNumber']");;
    private By dateOfBirth=By.xpath("//input[@id='dateOfBirthInput']");
    private By subjects=By.xpath("//input[@id='subjectsInput']");
    private By hobbiesSport=By.xpath("//label[text()='Sports']");
    private By hobbiesRead=By.xpath("//label[text()='Reading']");
    private By hobbiesMusic=By.xpath("//label[text()='Music']");
    private By selectPicture=By.xpath("//input[@type='file']");
    private By currentAddress=By.xpath("//textarea[@id='currentAddress']");
    private By selectState=By.xpath("//div[@id='state']");
    private By selectCity=By.xpath("//div[@id='city']");
    private By submit=By.xpath("//button[@id='submit']");
    private By table=By.xpath("//table");


    public PracticeForm enterFirstName(){
        $(firstName).sendKeys(practiceFormData.getFIRST_NAME());
        return this;
    }
    public WebElement getTable(){
        return $(table);
    }

    public PracticeForm enterLastName(){
        $(lastName).sendKeys(practiceFormData.getLAST_NAME());
        return this;
    }

    public PracticeForm enterEmail(){
        $(email).sendKeys(practiceFormData.getEMAIL());
        return this;
    }

    public PracticeForm clickGenderMale(){
        $(genderMale).click();
        return this;
    }

    public PracticeForm clickGenderFemale(){
        $(genderFemale).click();
        return this;
    }

    public PracticeForm clickGenderOther(){
        $(genderOther).click();
        return this;
    }

    public PracticeForm enterMobilePhone(){
        $(mobile).sendKeys(practiceFormData.getPHONE());
        return this;
    }
    public PracticeForm enterDateOfBirth(){
        $(dateOfBirth).sendKeys(RandomDataGenerator.getRandomDateOfBirth());
        $(dateOfBirth).sendKeys(Keys.ENTER);
        return this;
    }
    public PracticeForm subject(){
        $(subjects).sendKeys("Maths");
        $(subjects).sendKeys(Keys.ENTER);
        return this;
    }
    public PracticeForm hobbies(){
        $(hobbiesSport).scrollTo();
        $(hobbiesSport).click();
        return this;
    }
    public PracticeForm selectPicture(){
        $(selectPicture).scrollTo();
        $(selectPicture).sendKeys("C:\\Users\\Lera\\Pictures\\1.jpg");
        return this;
    }
    public PracticeForm currentAddress(){
        $(currentAddress).sendKeys(practiceFormData.getCURRENT_ADDRESS());
        return this;
    }
    public PracticeForm selectState(String state){
        $(selectState).scrollTo();
        $(selectState).click();
        List<WebElement> elementsState=getWebDriver().findElements(By.xpath("//div[contains(@class,'menu')]/div"));
        for (int i=0; i<elementsState.size(); i++){
            switch (state){
                case "NCR":
                    elementsState.get(0).click();
                    break;
                case "Uttar":
                    elementsState.get(1).click();
                    break;
                case "Haryana":
                    elementsState.get(2).click();
                    break;
                case "Rajasthan":
                    elementsState.get(3).click();
                    break;
                default:break;
            }
        }
        return this;
    }
    public PracticeForm selectCity(){
        $(selectCity).click();
        List<WebElement> elementsCity=getWebDriver().findElements(By.xpath("//div[contains(@class,'menu')]/div"));
        for (WebElement el:
             elementsCity) {
            System.out.println(el.getText());
            el.click();
        }
        return this;
    }
    public PracticeForm clickSubmit(){
        $(submit).click();
        return this;
    }
    public PracticeForm fillForm(){
        enterFirstName();
        enterLastName();
        enterEmail();
        clickGenderMale();
        enterMobilePhone();
        enterDateOfBirth();
        subject();
        hobbies();
        selectPicture();
        currentAddress();
        selectState("NCR");
        selectCity();
      //  clickSubmit();
        return this;
    }
    public List<String> getDataForm(){
        List<String> data =new ArrayList<>();
        data.add(practiceFormData.getFIRST_NAME()+" "+practiceFormData.getLAST_NAME());
        data.add(practiceFormData.getEMAIL());
        data.add($(genderMale).getText());
        data.add(practiceFormData.getPHONE());
        data.add(practiceFormData.getDATE_OF_BIRTH());
        data.add($(subjects).getText());
        data.add($(hobbiesSport).getText());
        data.add($(selectPicture).getText());
        data.add(practiceFormData.getCURRENT_ADDRESS());
        data.add($(selectState).getText()+" "+$(selectCity).getText());

        return data;
    }
    public List<WebElement> getRows(){
        List<WebElement> rows=getTable().findElements(By.xpath("//td[2]"));
        return rows;
    }


}
