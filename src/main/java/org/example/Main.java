package org.example;

import org.example.models.GreekPhoneNumber;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String output=input.replaceAll("\\s+","");
        GreekPhoneNumber number=new GreekPhoneNumber();
        number.setNumber(output);
        System.out.println(number.toString());
    }

    
}