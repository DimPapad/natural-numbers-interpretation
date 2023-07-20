package org.example.models;

import java.awt.desktop.QuitEvent;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GreekPhoneNumberPossibleOutput extends PossibleOutput{


    @Override
    protected Queue<SequenceModel> createAllPossibleCombinations(SequenceModel input) {
        Queue<SequenceModel> possibleOutputs=new LinkedList<>();

        Queue<String> subStrings=new LinkedList<>(Arrays.asList(input.getValue().split("\\s+")));
        for (String subString : subStrings) {
            createSubStringCombinationsForTwoDigits(subString);
        }

        return possibleOutputs;
    }

    private Queue<String> createSubStringCombinationsForTwoDigits(String subString){
        Queue<String> subStringCombinations=new LinkedList<>();
        if (subString.length()==2 && Integer.parseInt(subString)>20){
            subStringCombinations.add(subString);
            subStringCombinations.add(String.valueOf(Integer.valueOf(subString.substring(0,1))*10));
            subStringCombinations.add(subString.substring(1,2));
        }
        return subStringCombinations;
    }

    private Queue<String> createSubStringCombinationsForThreeDigits(String subString){
        Queue<String> subStringCombinations=new LinkedList<>();
        if (subString.length()==3){
            subStringCombinations.add(subString);
            subStringCombinations.add(String.valueOf(Integer.valueOf(subString.substring(0,1))*10));
            subStringCombinations.add(subString.substring(1,2));
        }
        return subStringCombinations;
    }


}
