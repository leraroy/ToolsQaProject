package data;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;


public class RandomDataGenerator {
    private static Faker faker=new Faker();
    private static Random random=new Random();

    public static String getRandomEmail() {
       SimpleDateFormat simpleDate = new SimpleDateFormat("hhmmss");
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String result = getRandomName() + "_" + simpleDate.format(date) + "@gmail.com";
        return result;
    }

    public static String getRandomName() {
        return RandomStringUtils.randomAlphabetic(5);
    }
    public static String getRandomAddress(){
        return faker.address().fullAddress();
    }
    public static String getRandomSalary(){
        return RandomStringUtils.randomNumeric(5);
    }
    public static String getRandomAge(){
        return String.valueOf(random.nextInt(100));
    }
    public static String getRandomDepartment(){
        return faker.company().bs();
    }
    public static String getRandomDateOfBirth(){
        
       return String.valueOf(faker.date().birthday());
    }

    public static String getRandomMobilePhone(){
        return faker.phoneNumber().subscriberNumber(10);
    }
    public static String getPassword() {
        String upperCaseLetters=RandomStringUtils.random(2,65,90,true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(2);
        String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        String name=RandomStringUtils.randomAlphanumeric(5);
        String totalChars = RandomStringUtils.randomAlphanumeric(2);
        String result=name+upperCaseLetters+lowerCaseLetters+numbers+specialChar+totalChars;
        return result;
    }
    public static String getRandomDate(String format){
            SimpleDateFormat sdf = new SimpleDateFormat(format,new Locale("en"));
            String date=sdf.format(faker.date().birthday());
            System.out.println(date);
            return date;
        }
    }

