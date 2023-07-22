package org.example.clients;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;
import org.example.models.*;

import java.util.List;
import java.util.Scanner;

public class Client {


    public void validateGreekPhoneNumberAndGetInterpretations() {
        // Input
        System.out.println("Input a number");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        // Print the number
        System.out.println();
        System.out.println("The Number");
        SimpleNumber simpleNumber=new SimpleNumber();
        simpleNumber.setNumber(userInput);
        System.out.println(simpleNumber.getNumber());

        // Number validation
        System.out.println();
        System.out.println("Greek phone number Validation");
        GreekPhoneNumber greekPhoneNumber = new GreekPhoneNumber();
        try {
            greekPhoneNumber.setNumber(userInput);
            System.out.println(greekPhoneNumber.getNumber() + " [phone number: VALID]");
        } catch (WrongGreekPhoneNumberFormatException e) {
            System.out.println(simpleNumber.getNumber() + " [phone number: INVALID]");
        }

        // Print possible interpretations
        System.out.println();
        System.out.println("Possible Interpretations");
        Output output = new GreekPhoneNumberOutput();
        output.setOutputs(userInput);
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
