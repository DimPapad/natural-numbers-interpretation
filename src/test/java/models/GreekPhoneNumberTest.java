package models;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;
import org.example.models.GreekPhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GreekPhoneNumberTest {


    GreekPhoneNumber greekPhoneNumber=new GreekPhoneNumber();

    @Test
    @DisplayName("Assert that a string sequence produces a solid number")
    public void assertGreekPhoneNumber(){
        greekPhoneNumber.setNumber("694 89 31 00 8");
        String numberValue="6948931008";
        Assertions.assertEquals(numberValue,greekPhoneNumber.getNumber());
    }

    @Test
    @DisplayName("Exceptions...")
    public void exceptions(){
        Exception exception1=Assertions.assertThrows(WrongGreekPhoneNumberFormatException.class, ()->greekPhoneNumber.setNumber("210123456789"));
        Assertions.assertEquals("INVALID NUMBER. Wrong number of digits.",exception1.getMessage());
        Exception exception2=Assertions.assertThrows(WrongGreekPhoneNumberFormatException.class, ()->greekPhoneNumber.setNumber("6848831007"));
        Assertions.assertEquals("INVALID NUMBER. Wrong first/second digit of number.",exception2.getMessage());
        Exception exception3=Assertions.assertThrows(WrongGreekPhoneNumberFormatException.class, ()->greekPhoneNumber.setNumber("3102245987"));
        Assertions.assertEquals("INVALID NUMBER. Wrong first/second digit of number.",exception3.getMessage());
    }

}
