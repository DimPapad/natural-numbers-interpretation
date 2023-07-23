package org.example.clients;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;
import org.example.exceptions.WrongInputException;
import org.example.models.*;

import java.util.List;
import java.util.Scanner;

public class Client {


    public void validateGreekPhoneNumberAndGetInterpretations() {
        // Input
        System.out.println("""
                Input a sequence by numbers.
                Each number must consist of max 3 digits.
                Sequence must have at least one space character.
                """);
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        // Input validation
        Input input=new NumberInput();
        try {
            input.setValue(userInput);
        } catch (WrongInputException e) {
            System.out.println("""
                    The input sequence contains at least one number that has more than 3 digits.
                    OR
                    The sequence has not a space character
                    TRY AGAIN!""");
            System.exit(1);
        }
        String validInput=input.getValue();

        // Print the number
        System.out.println();
        System.out.println("The Number");
        SimpleNumber simpleNumber=new SimpleNumber();
        simpleNumber.setNumber(validInput);
        System.out.println(simpleNumber.getNumber());

        // Number validation
        System.out.println();
        System.out.println("Greek phone number Validation");
        GreekPhoneNumber greekPhoneNumber = new GreekPhoneNumber();
        try {
            greekPhoneNumber.setNumber(validInput);
            System.out.println(greekPhoneNumber.getNumber() + " [phone number: VALID]");
        } catch (WrongGreekPhoneNumberFormatException e) {
            simpleNumber.setNumber(validInput);
            System.out.println(simpleNumber.getNumber() + " [phone number: INVALID]");
        }

        // Print possible interpretations
        System.out.println();
        System.out.println("Possible Interpretations");
        Output output = new GreekPhoneNumberOutput();
        output.setOutputs(validInput);
        List<NumberEntity> outputs = output.getOutputs();
        for (NumberEntity distinctOutput : outputs) {
            if (distinctOutput instanceof GreekPhoneNumber) {
                System.out.print(distinctOutput);
                System.out.println(" [phone number: VALID]");
            }
            if (distinctOutput instanceof SimpleNumber) {
                System.out.print(distinctOutput);
                System.out.println(" [phone number: INVALID]");
            }
        }
    }


}
