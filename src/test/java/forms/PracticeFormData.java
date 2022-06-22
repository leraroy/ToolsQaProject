package forms;

import data.Options;
import data.RandomDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lera on 15.06.2022
 */
public class PracticeFormData {
    private final String FIRST_NAME= RandomDataGenerator.getRandomName();
    private final String LAST_NAME= RandomDataGenerator.getRandomName();
    private final String EMAIL= RandomDataGenerator.getRandomEmail();
    private final String PHONE= RandomDataGenerator.getRandomMobilePhone();
    private final String DATE_OF_BIRTH= RandomDataGenerator.getRandomDateOfBirth();
    private final String CURRENT_ADDRESS= RandomDataGenerator.getRandomAddress();

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public String getDATE_OF_BIRTH() {
        return DATE_OF_BIRTH;
    }

    public String getCURRENT_ADDRESS() {
        return CURRENT_ADDRESS;
    }


}
