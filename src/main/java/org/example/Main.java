package org.example;

import org.example.clients.Client;
import org.example.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Client client=new Client();
        List<OutputEntity> interpretations=client.getAllValidInterpretationsFromGivenInput();
        System.out.println(interpretations);
    }

    
}