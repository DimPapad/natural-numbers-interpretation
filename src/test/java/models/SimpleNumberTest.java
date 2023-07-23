package models;

import org.example.models.SimpleNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleNumberTest {


    @Test
    @DisplayName("Assert that a simple number output is produced without spaces from the sequence input")
    public void assertThatSimpleNumberIsProducedWithoutSpacesFromInput() {
        SimpleNumber simpleNumber=new SimpleNumber();
        simpleNumber.setNumber("213 45 12");
        Assertions.assertEquals("2134512", simpleNumber.getNumber());
    }


}
