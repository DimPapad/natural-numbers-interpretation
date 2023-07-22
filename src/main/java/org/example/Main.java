package org.example;

import org.example.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String initialInput=sc.nextLine();

        String initialInput="2 10 6 9 30 6 6 4";
        SequenceModel input=new GreekPhoneNumberInput();
        input.setValue(initialInput);
        Output output=new GreekPhoneNumberOutput();
        output.setOutputs(input);
        System.out.println(output.getOutputs());
    }

    
}