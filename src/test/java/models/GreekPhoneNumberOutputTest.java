package models;

import org.example.models.GreekPhoneNumberOutput;
import org.example.models.NumberEntity;
import org.example.models.SimpleNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GreekPhoneNumberOutputTest {


    @Test
    @DisplayName("Production of all outputs from division and combination of substrings of a sequence")
    public void assertThatAllOutputsAreProducedFromDivisionAndCombinationOfSubStringsOfASequence() {
        GreekPhoneNumberOutput output=new GreekPhoneNumberOutput();
        output.setOutputs("2 10 69 30 6 6 4");
        List<NumberEntity> expectedOutputs=new ArrayList<>();
        NumberEntity entity1=new SimpleNumber();
        entity1.setNumber("210693664");
        expectedOutputs.add(entity1);
        NumberEntity entity2=new SimpleNumber();
        entity2.setNumber("2106930664");
        expectedOutputs.add(entity2);
        NumberEntity entity3=new SimpleNumber();
        entity3.setNumber("2106093664");
        expectedOutputs.add(entity3);
        NumberEntity entity4=new SimpleNumber();
        entity4.setNumber("21060930664");
        expectedOutputs.add(entity4);
        expectedOutputs.forEach(expOutput->
                Assertions.assertEquals(
                        expOutput.getNumber(),
                        output.getOutputs().stream().filter(resOutput->resOutput.getNumber().equals(expOutput.getNumber())).findFirst().get().getNumber()
                ));
    }


}
