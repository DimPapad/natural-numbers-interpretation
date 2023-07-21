package org.example.models;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;

import java.util.*;

public class GreekPhoneNumberOutput extends Output{


    @Override
    protected List<OutputEntity> createAllValidOutputs(SequenceModel input) {
        List<OutputEntity> outputs=new ArrayList<>();
        List<String> stringOutputs=new ArrayList<>();
        List<List<String>> possibleSubStrings=new ArrayList<>();
        List<List<String>> possibleSuperStrings=new ArrayList<>();
        List<List<String>> possibleSubAndSuperStrings=new ArrayList<>();

        List<String> subStrings=new ArrayList<>(Arrays.asList(input.getValue().split("\\s+")));
        for (String subString : subStrings) {
            possibleSubStrings.add(createPossibleSubStrings(subString));
        }

        //possibleSuperStrings=createSuperStrings();

        possibleSubAndSuperStrings.addAll(possibleSubStrings);
        possibleSubAndSuperStrings.addAll(possibleSuperStrings);

        generatePermutations(possibleSubAndSuperStrings, stringOutputs, 0, "");

        for (String stringOutput : stringOutputs) {
            try {
                GreekPhoneNumber number=new GreekPhoneNumber();
                number.setNumber(stringOutput);
                outputs.add(number);
            } catch (WrongGreekPhoneNumberFormatException e){
                e.printStackTrace();
            }
        }

        return outputs;
    }

    private List<String> createPossibleSubStrings(String subString){
        List<String> subStringCombinations=new ArrayList<>();
        subStringCombinations.add(subString);
        switch (subString.length()){
            case 2:
                if (Integer.parseInt(subString)>20) {
                    subStringCombinations.add(subString.substring(0, 1) + "0" + subString.substring(1, 2));
                }
                break;
            case 3:
                subStringCombinations.add(subString.substring(0,1)+"00"+subString.substring(1,3));
                if (Integer.parseInt(subString.substring(1,3))>20) {
                    subStringCombinations.add(subString.substring(0, 1) + "00" + subString.substring(1, 2)+ "0" + subString.substring(2,3));
                }
                break;
        }
        if (subStringCombinations.size()<3){
            for (int i = 0; i < 3-subStringCombinations.size(); i++) {
                subStringCombinations.add("");
            }
        }
        return subStringCombinations;
    }

    private List<String> createPossibleSuperStrings(String subString, String nextSubString){
        List<String> superStringCombinations=new ArrayList<>();



        return superStringCombinations;
    }

    private void generatePermutations(List<List<String>> lists, List<String> result, int depth, String current) {
        if (depth == lists.size()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
        }
    }


}
