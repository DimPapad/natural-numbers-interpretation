package org.example.models;

import org.example.exceptions.WrongInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberInput extends Input {


    @Override
    protected String checkValue(String sequence) {
        List<String> subStrings=new ArrayList<>(Arrays.asList(sequence.split("\\s+")));
        List<String> subStringsWithMoreThanThreeDigits=subStrings
                                                                .stream()
                                                                .filter(subString->subString.length()>3)
                                                                .collect(Collectors.toList());
        if (!subStringsWithMoreThanThreeDigits.isEmpty() || subStrings.size()==1){
            throw new WrongInputException("The input sequence contains at least one number that has more than 3 digits. -OR- The sequence has not a space character.");
        }
        return sequence;
    }


}
