package models;

import org.example.exceptions.WrongInputException;
import org.example.models.NumberInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberInputTest {


    @Test
    @DisplayName("Assert that a sequence input has the right syntax.")
    public void assertThatASequenceInputHasTheRightSyntax() {
        NumberInput numberInput=new NumberInput();
        Exception noSpace=Assertions.assertThrows(WrongInputException.class, ()->numberInput.setValue("634545"));
        Assertions.assertEquals("The input sequence contains at least one number that has more than 3 digits. -OR- The sequence has not a space character.", noSpace.getMessage());
        Exception moreThanThreeDigits=Assertions.assertThrows(WrongInputException.class, ()->numberInput.setValue("63 3 345 1234"));
        Assertions.assertEquals("The input sequence contains at least one number that has more than 3 digits. -OR- The sequence has not a space character.", moreThanThreeDigits.getMessage());
        Assertions.assertDoesNotThrow(()->numberInput.setValue("678 45 33"));
        Assertions.assertEquals("678 45 33", numberInput.getValue());
    }


}
