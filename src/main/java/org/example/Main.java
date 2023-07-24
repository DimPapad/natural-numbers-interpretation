package org.example;

import org.example.clients.Client;
import org.example.exceptions.WrongInputException;
import org.example.models.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String userInput = userInput();

        Client client=new Client();

        Optional<Input> input=validateInputAndGet(client, userInput);

        SimpleNumber simpleNumber=printAndGetNumberFromSequence(client, input.get().getValue());

        validateGreekPhoneNumberAndPrint(client, input.get().getValue(), simpleNumber);

        printNumberInterpretations(client, input.get().getValue());
    }

    private static String userInput() {
        System.out.println("""
                Input a sequence by numbers.
                Each number must consist of max 3 digits.
                Sequence must have at least one space character.
                """);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static Optional<Input> validateInputAndGet(Client client, String userInput) {
        Optional<Input> input=client.validateInputAndGet(userInput);
        if (input.isEmpty()){
            System.out.println("""
                    The input sequence contains at least one number that has more than 3 digits.
                    OR
                    The sequence has not a space character
                    TRY AGAIN!""");
            System.exit(1);
        }
        return input;
    }

    private static SimpleNumber printAndGetNumberFromSequence(Client client, String validInput) {
        SimpleNumber simpleNumber=client.getNumberFromSequence(validInput);
        System.out.println("The Number");
        System.out.println(simpleNumber.getNumber());
        System.out.println();
        return simpleNumber;
    }

    private static Optional<GreekPhoneNumber> validateGreekPhoneNumberAndPrint(Client client, String validInput, SimpleNumber simpleNumber) {
        Optional<GreekPhoneNumber> optionalNumber=client.validateGreekPhoneNumberAndGet(validInput);
        System.out.println("Greek phone number Validation");
        if (optionalNumber.isPresent()) {
            System.out.println(optionalNumber.get().getNumber() + " [phone number: VALID]");
        }
        if (optionalNumber.isEmpty()){
            System.out.println(simpleNumber.getNumber() + " [phone number: INVALID]");
        }
        System.out.println();
        return optionalNumber;
    }

    private static void printNumberInterpretations(Client client, String validInput) {
        System.out.println("Number Interpretations");
        List<NumberEntity> interpretations=client.getNumberInterpretations(validInput);
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