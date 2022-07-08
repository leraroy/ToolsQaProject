package forms;

import data.DatePicker;
import org.openqa.selenium.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class PracticeForm extends PracticeFormData{

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
        $(firstName).sendKeys(getFIRST_NAME());
        return this;
    }
    public WebElement getTable(){
        return $(table);
    }

    public PracticeForm enterLastName(){
        $(lastName).sendKeys(getLAST_NAME());
        return this;
    }

    public PracticeForm enterEmail(){
        $(email).sendKeys(getEMAIL());
        return this;
    }

    public PracticeForm clickGenderMale(){
        $(genderMale).click();
        setGENDER($(genderMale).getText());
        return this;
    }

    public PracticeForm clickGenderFemale(){
        $(genderFemale).click();
        setGENDER($(genderFemale).getText());
        return this;
    }

    public PracticeForm clickGenderOther(){
        $(genderOther).click();
        setGENDER($(genderOther).getText());
        return this;
    }

    public PracticeForm enterMobilePhone(){
        $(mobile).sendKeys(getPHONE());
        return this;
    }
    public PracticeForm enterDateOfBirth() throws InterruptedException {
        $(dateOfBirth).scrollTo();
        DatePicker datePicker=new DatePicker();
        datePicker.clickSelectDate(dateOfBirth);
        String [] arrayDate=getDATE_OF_BIRTH().split("/");
        datePicker.selectDateYear(arrayDate[2]);
        datePicker.selectDateMonth(arrayDate[1]);
        Thread.sleep(200);
        datePicker.selectDateDay(arrayDate[0]);
        return this;
    }
    public PracticeForm subject(){
        $(subjects).scrollTo().sendKeys("Maths");
        $(subjects).sendKeys(Keys.ENTER);
        setSUBJECT($(By.xpath("(//div[contains(@class, 'multi-value')])[1]")).getText());
        return this;
    }
    public PracticeForm hobbies(){
        $(hobbiesSport).scrollTo().click();
        setHOBBIES($(hobbiesSport).getText());
        return this;
    }
    public PracticeForm selectPicture(){
        $(selectPicture).scrollTo().sendKeys("C:\\Users\\Lera\\Pictures\\1.jpg");
        setPICTURE("1.jpg");
        return this;
    }
    public PracticeForm currentAddress(){
        $(currentAddress).sendKeys(getCURRENT_ADDRESS());
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
            el.click();
        }
        return this;
    }
    public PracticeForm clickSubmit(){
        $(submit).scrollTo().click();
        return this;
    }
    public List<String> getInvalidBorderInput() throws InterruptedException {
        String properties="border-color";
        List<String> colors=new ArrayList<>();
        colors.add($(firstName).getCssValue(properties));
        colors.add($(lastName).getCssValue(properties));
        $(email).sendKeys("!",Keys.ENTER);
        Thread.sleep(200);
        colors.add($(email).getCssValue(properties));
        colors.add($(mobile).getCssValue(properties));
        colors.add($(genderMale).getCssValue(properties));
        colors.add($(genderFemale).getCssValue(properties));
        colors.add($(genderOther).getCssValue(properties));
        return colors;
    }
    public PracticeForm fillForm() throws InterruptedException {
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
        clickSubmit();
        return this;
    }
    public List<String> getDataForm(){
        List<String> data =new ArrayList<>();
        data.add(getFIRST_NAME()+" "+getLAST_NAME());
        data.add(getEMAIL());
        data.add(getGENDER());
        data.add(getPHONE());
        data.add(getDATE_OF_BIRTH());
        data.add(getSUBJECT());
        data.add(getHOBBIES());
        data.add(getPICTURE());
        data.add(getCURRENT_ADDRESS());
        data.add($(selectState).getText()+" "+$(By.xpath("//div[@id='city']//div[contains(@class, 'singleValue')]")).getText());
        return data;
    }
    public List<String> getResultTable() throws ParseException {
        List<WebElement> rows=getTable().findElements(By.xpath("//td[2]"));
        List<String> result_table=new ArrayList<>();
        for (WebElement e :
                rows) {
            result_table.add(e.getText());
        }
        Date date1=new SimpleDateFormat("dd MMMM,yyyy",new Locale("en")).parse(result_table.get(4));
        String date=new SimpleDateFormat("dd/MM/yyyy", new Locale("en")).format(date1);
        result_table.remove(4);
        result_table.add(4,date);
        return result_table;
    }


}
