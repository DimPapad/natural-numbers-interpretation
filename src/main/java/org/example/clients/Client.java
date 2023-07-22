package org.example.clients;

import org.example.models.*;

import java.util.List;
import java.util.Scanner;

public class Client {


    public List<OutputEntity> getAllValidInterpretationsFromGivenInput(){
        Scanner sc=new Scanner(System.in);
        String userInput=sc.nextLine();
        Output output=new GreekPhoneNumberOutput();
        output.setOutputs(userInput);
        return output.getOutputs();
    }


}
