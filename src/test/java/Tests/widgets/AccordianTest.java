package Tests.widgets;

import org.junit.Assert;
import org.junit.Test;
import widgets.Accordian;

import java.io.File;

/**
 * Created by Lera on 19.06.2022
 */
public class AccordianTest {

    Accordian accordian=new Accordian();

    @Test
    public void checkTextWhatIs(){
        accordian.clickWhatIs();
        accordian.getTextWhatIsToFile();
        File expected=new File("What_is_Lorem_Ipsum.txt");
        File actual=new File("actual.txt");
        Assert.assertTrue(accordian.isEqual(expected,actual));
    }
}
