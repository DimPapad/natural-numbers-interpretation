package org.example.clients;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;
import org.example.exceptions.WrongInputException;
import org.example.models.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Client {


    public Optional<Input> validateInputAndGet(String userInput) {
        Input input=new NumberInput();
        try {
            input.setValue(userInput);
            return Optional.of(input);
        } catch (WrongInputException e) {
            return Optional.empty();
        }
    }

    public SimpleNumber getNumberFromSequence(String validInput) {
        SimpleNumber simpleNumber=new SimpleNumber();
        simpleNumber.setNumber(validInput);
        return simpleNumber;
    }

    public Optional<GreekPhoneNumber> validateGreekPhoneNumberAndGet(String validInput) {
        GreekPhoneNumber greekPhoneNumber = new GreekPhoneNumber();
        try {
            greekPhoneNumber.setNumber(validInput);
            return Optional.of(greekPhoneNumber);
        } catch (WrongGreekPhoneNumberFormatException e) {
            return Optional.empty();
        }
    }

    public List<NumberEntity> getNumberInterpretations(String validInput) {
        Output output = new GreekPhoneNumberOutput();
        output.setOutputs(validInput);
        return output.getOutputs();
    }


}
