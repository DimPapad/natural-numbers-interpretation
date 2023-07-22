package org.example;

import org.example.clients.Client;
import org.example.models.*;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        Client client=new Client();
        client.validateGreekPhoneNumberAndGetInterpretations();
    }

    
}