package forms;

import data.RandomDataGenerator;


public class PracticeFormData {

    private String FIRST_NAME= RandomDataGenerator.getRandomName();
    private String LAST_NAME= RandomDataGenerator.getRandomName();
    private String EMAIL= RandomDataGenerator.getRandomEmail();
    private String PHONE= RandomDataGenerator.getRandomMobilePhone();
    private String DATE_OF_BIRTH= RandomDataGenerator.getRandomDate("dd/MM/yyyy");
    private String CURRENT_ADDRESS=RandomDataGenerator.getRandomAddress();;
    private String PICTURE;
    private String SUBJECT;
    private String GENDER;
    private String HOBBIES;


    public String getPICTURE() {
        return PICTURE;
    }
    public String getHOBBIES() {
        return HOBBIES;
    }

    public String getSUBJECT() {
        return SUBJECT;
    }

    public String getGENDER() {
        return GENDER;
    }

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

    public void setPICTURE(String picture){
        PICTURE=picture;
    }
    public void setHOBBIES(String hobbies) {
        HOBBIES=hobbies;
    }
    public void setSUBJECT(String subject){
        SUBJECT=subject;
    }
    public void setGENDER(String gender){
        GENDER=gender;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public void setDATE_OF_BIRTH(String DATE_OF_BIRTH) {
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
    }

    public void setCURRENT_ADDRESS(String CURRENT_ADDRESS) {
        this.CURRENT_ADDRESS = CURRENT_ADDRESS;
    }
}
