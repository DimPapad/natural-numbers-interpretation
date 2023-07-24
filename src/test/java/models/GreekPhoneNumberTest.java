package models;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;
import org.example.models.GreekPhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GreekPhoneNumberTest {


    GreekPhoneNumber greekPhoneNumber=new GreekPhoneNumber();

    @Test
    @DisplayName("Assert that a string sequence with spaces produces a solid valid greek phone number")
    public void assertGreekPhoneNumberProductionFromStringSequenceWithSpaces(){
        greekPhoneNumber.setNumber("694 89 31 00 8");
        String numberValue="6948931008";
        Assertions.assertEquals(numberValue,greekPhoneNumber.getNumber());
        greekPhoneNumber.setNumber("00 30 213 725 904 1");
        numberValue="00302137259041";
        Assertions.assertEquals(numberValue,greekPhoneNumber.getNumber());
    }

    @Test
    @DisplayName("Assert that a greek phone number has the right count of digits")
    public void assertGreekPhoneNumberDigitCount(){
        Exception exception=Assertions.assertThrows(WrongGreekPhoneNumberFormatException.class, ()->greekPhoneNumber.setNumber("210123456789"));
        Assertions.assertEquals("INVALID NUMBER. Wrong number of digits.",exception.getMessage());
    }

    @Test
    @DisplayName("Assert that a greek phone number starts with the right digit(s)")
    public void assertGreekPhoneNumberStartsWithTheRightDigit(){
        Exception mobileExample=Assertions.assertThrows(WrongGreekPhoneNumberFormatException.class, ()->greekPhoneNumber.setNumber("6848831007"));
        Assertions.assertEquals("INVALID NUMBER. Wrong first/second digit of number.",mobileExample.getMessage());
        Exception phoneExample=Assertions.assertThrows(WrongGreekPhoneNumberFormatException.class, ()->greekPhoneNumber.setNumber("3102245987"));
        Assertions.assertEquals("INVALID NUMBER. Wrong first/second digit of number.",phoneExample.getMessage());
    }

}
