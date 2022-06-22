package elements;

import data.Options;
import data.RandomDataGenerator;
import data.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class WebTables extends Options {
    //private WebDriver driver;

    private By addButton = By.xpath("//button[text()='Add']");
    private By searchBox = By.xpath("//input[@id='searchBox']");
    private By table=By.xpath("//div[@class='rt-table']");

    //REGISTRATION FORM
    private By firstName = By.xpath("//input[@id='firstName']");
    private By lastName = By.xpath("//input[@id='lastName']");
    private By email = By.xpath("//input[@id='userEmail']");
    private By age = By.xpath("//input[@id='age']");
    private By salary = By.xpath("//input[@id='salary']");
    private By department = By.xpath("//input[@id='department']");
    private By submit = By.xpath("//button[@id='submit']");
    private By delete = By.xpath("//span[@title='Delete']");
    private By edit = By.xpath("//span[@title='Edit']");

    public WebElement getTable() {
        return $(table);
    }
    private Table tableClass=new Table(getTable(),getWebDriver());

    public WebTables clickOnAdd() {
        $(addButton).click();
        return this;
    }

    public WebTables enterFirstName() {
        $(firstName).sendKeys(RandomDataGenerator.getRandomName());
        return this;
    }

    public WebTables enterLastName() {
        $(lastName).sendKeys(RandomDataGenerator.getRandomName());
        return this;
    }

    public WebTables enterEmail() {
        $(email).sendKeys(RandomDataGenerator.getRandomEmail());
        return this;
    }

    public WebTables enterAge() {
        $(age).sendKeys(RandomDataGenerator.getRandomAge());
        return this;
    }

    public WebTables enterSalary() {
        $(salary).sendKeys(RandomDataGenerator.getRandomSalary());
        return this;
    }

    public WebTables enterDepartment() {
        $(department).sendKeys(RandomDataGenerator.getRandomDepartment());
        return this;
    }

    public WebTables clickOnSubmit() {
        $(submit).click();
        return this;
    }

    public WebTables fillRegisterForm() {
        enterFirstName();
        enterLastName();
        enterEmail();
        enterAge();
        enterSalary();
        enterDepartment();
        clickOnSubmit();
        return this;
    }

    public WebTables fillTable() {
        for (int i = 0; i < 5; i++) {
            clickOnAdd();
            fillRegisterForm();
        }
        return this;
    }

    public void printHeadings(){
        for (WebElement e:
                tableClass.getHeading()) {
            System.out.println(e.getText());
        }
    }
    public void printRows(){
        for (WebElement e:
                tableClass.getRows()) {
            System.out.println(e.getText());
        }
    }
    public String getCell(){
        return tableClass.getValueCell(2, 2);
    }

}
