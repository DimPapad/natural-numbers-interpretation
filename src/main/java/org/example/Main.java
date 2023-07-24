package org.example;

import org.example.clients.Client;
import org.example.exceptions.WrongInputException;
import org.example.models.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // Input from user
        System.out.println("""
                Input a sequence by numbers.
                Each number must consist of max 3 digits.
                Sequence must have at least one space character.
                """);
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        System.out.println();

        // Client actions
        Client client=new Client();
        // Input validation and get
        Optional<Input> input=client.validateInputAndGet(userInput);
        if (input.isEmpty()){
            System.out.println("""
                    The input sequence contains at least one number that has more than 3 digits.
                    OR
                    The sequence has not a space character
                    TRY AGAIN!""");
            System.exit(1);
        }

        // Get the number from sequence
        SimpleNumber simpleNumber=client.getNumberFromSequence(input.get().getValue());
        System.out.println("The Number");
        System.out.println(simpleNumber.getNumber());
        System.out.println();

        // Number validation
        System.out.println("Greek phone number Validation");
        Optional<GreekPhoneNumber> optionalNumber=client.validateGreekPhoneNumberAndGet(input.get().getValue());
        if (optionalNumber.isPresent()) {
            System.out.println(optionalNumber.get().getNumber() + " [phone number: VALID]");
        }
        if (optionalNumber.isEmpty()){
            System.out.println(simpleNumber.getNumber() + " [phone number: INVALID]");
        }
        System.out.println();

        // Get number interpretations
        System.out.println("Number Interpretations");
        List<NumberEntity> interpretations=client.getNumberInterpretations(input.get().getValue());
        for (NumberEntity interpretation : interpretations) {
            if (interpretation instanceof GreekPhoneNumber) {
                System.out.print(interpretation);
                System.out.println(" [phone number: VALID]");
            }
            if (interpretation instanceof SimpleNumber) {
                System.out.print(interpretation);
                System.out.println(" [phone number: INVALID]");
            }
        }
    }

    
}