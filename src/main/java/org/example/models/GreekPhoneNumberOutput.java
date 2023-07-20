package org.example.models;

import java.util.*;

public class GreekPhoneNumberOutput extends Output{


    @Override
    protected List<String> createAllValidOutputs(SequenceModel input) {
        List<String> possibleOutputs=new LinkedList<>();

        List<List<String>> combinations=new ArrayList<>();

        Queue<String> subStrings=new LinkedList<>(Arrays.asList(input.getValue().split("\\s+")));
        for (String subString : subStrings) {
            combinations.add(createSubStringCombinations(subString));
        }

        StringBuilder combination=new StringBuilder();
        GreekPhoneNumber number=new GreekPhoneNumber();
        for (int i = 0; i < combinations.size(); i++) {
            for (int j = 0; j < combinations.get(i).size(); j++) {
                combination=combination.append(combinations.get(j).get(i));
            }
            number.setNumber(String.valueOf(combination));
            possibleOutputs.add(number.getNumber());
        }

        return possibleOutputs;
    }

//    private Queue<String> createSubStringCombinationsForTwoDigits(String subString){
//        Queue<String> subStringCombinations=new LinkedList<>();
//        subStringCombinations.add(subString);
//        if (Integer.parseInt(subString)>20) {
//            subStringCombinations.add(subString.substring(0, 1)+ "0"+subString.substring(1, 2));
//        }
//        return subStringCombinations;
//    }
//
//    private Queue<String> createSubStringCombinationsForThreeDigits(String subString){
//        Queue<String> subStringCombinations=new LinkedList<>();
//        subStringCombinations.add(subString);
//        subStringCombinations.add(subString.substring(0,1)+"00"+subString.substring(1,3));
//        subStringCombinations.add(createSubStringCombinationsForTwoDigits(subString.substring(1,3)));
//        return subStringCombinations;
//    }

    private List<String> createSubStringCombinations(String subString){
        List<String> subStringCombinations=new ArrayList<>();
        subStringCombinations.add(subString);
        switch (subString.length()){
            case 2:
                if (Integer.parseInt(subString)>20) {
                    subStringCombinations.add(subString.substring(0, 1) + "0" + subString.substring(1, 2));
                }
            case 3:
                subStringCombinations.add(subString.substring(0,1)+"00"+subString.substring(1,3));
                if (Integer.parseInt(subString)>20) {
                    subStringCombinations.add(subString.substring(0, 1) + "00" + subString.substring(1, 2)+ "0" + subString.substring(2,3));
                }
        }
        return subStringCombinations;
    }


}
