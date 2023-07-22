package org.example.models;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;

import java.util.*;

public class GreekPhoneNumberOutput extends Output{


    @Override
    protected List<OutputEntity> createAllValidOutputs(SequenceModel input) {
        List<String> inputSubStrings=new ArrayList<>(Arrays.asList(input.getValue().split("\\s+")));
        List<List<String>> subStringsFromDivision=generateSubStringsFromDivision(inputSubStrings);
        List<List<String>> subStringsFromCombination=generateSubStringsFromCombination(inputSubStrings);
        List<List<String>> subStringsFromDivisionAndCombination=combineSubStringsFromDivisionAndCombination(subStringsFromDivision, subStringsFromCombination);

        List<String> permutations=new ArrayList<>();
        generatePermutations(subStringsFromDivisionAndCombination, permutations, 0, "");

        List<OutputEntity> interpretations=generateGreekPhoneNumbersFromStrings(permutations);

        return interpretations;
    }

    private List<List<String>> generateSubStringsFromDivision(List<String> subStrings){
        List<List<String>> subStringsFromDivision=new ArrayList<>();
        for (String subString : subStrings) {
            List<String> subStringDivisions=new ArrayList<>();
            subStringDivisions.add(subString);
            switch (subString.length()){
                case 2:
                    if (Integer.parseInt(subString)>=20 && !subString.substring(1, 2).equals("0")) {
                        subStringDivisions.add(subString.substring(0, 1) + "0" + subString.substring(1, 2));
                    }
                    break;
                case 3:
                    subStringDivisions.add(subString.substring(0,1)+"00"+subString.substring(1,3));
                    if (Integer.parseInt(subString.substring(1,3))>=20 && !subString.substring(2, 3).equals("0")) {
                        subStringDivisions.add(subString.substring(0, 1) + "00" + subString.substring(1, 2)+ "0" + subString.substring(2,3));
                    }
                    break;
            }
            subStringsFromDivision.add(subStringDivisions);
        }
        return subStringsFromDivision;
    }

    private List<List<String>> generateSubStringsFromCombination(List<String> subStrings){
        List<List<String>> subStringsFromCombination=new ArrayList<>();
        for (int i = 0; i < subStrings.size()-1; i++) {
            List<String> subStringCombinations=new ArrayList<>();
            switch (subStrings.get(i).length()) {
                case 2:
                    if (Integer.parseInt(subStrings.get(i))>=20 && subStrings.get(i).substring(1, 2).equals("0") && subStrings.get(i+1).length()==1) {
                        subStringCombinations.add(subStrings.get(i));
                        subStringCombinations.add(subStrings.get(i).substring(0,1));
                    }
                    else {
                        subStringCombinations.add(subStrings.get(i));
                    }
                    break;
                case 3:
                    if (subStrings.get(i).substring(1, 3).equals("00")) {
                        if (subStrings.get(i + 1).length() == 2) {
                            subStringCombinations.add(subStrings.get(i));
                            subStringCombinations.add(subStrings.get(i).substring(0, 1));
                        } else if (subStrings.get(i + 1).length() == 1) {
                            subStringCombinations.add(subStrings.get(i));
                            subStringCombinations.add(subStrings.get(i).substring(0, 2));
                        }
                    }
                    else {
                        subStringCombinations.add(subStrings.get(i));
                    }
                    break;
                default:
                    subStringCombinations.add(subStrings.get(i));
            }
            subStringsFromCombination.add(subStringCombinations);
        }
        subStringsFromCombination.add(new ArrayList<String>(Arrays.asList(subStrings.get(subStrings.size()-1))));
        return subStringsFromCombination;
    }

    private List<List<String>> combineSubStringsFromDivisionAndCombination(List<List<String>> subStringsFromDivision, List<List<String>> subStringsFromCombination){
        List<Set<String>> subStringsFromDivisionAndCombinationInSets = new ArrayList<>();
        List<List<String>> subStringsFromDivisionAndCombinationInLists = new ArrayList<>();
        for (int i = 0; i < subStringsFromDivision.size(); i++) {
            subStringsFromDivisionAndCombinationInSets.add(new HashSet<>(subStringsFromDivision.get(i)));
            subStringsFromDivisionAndCombinationInSets.get(i).addAll(subStringsFromCombination.get(i));
            subStringsFromDivisionAndCombinationInLists.add(new ArrayList<>(subStringsFromDivisionAndCombinationInSets.get(i)));
        }
        return subStringsFromDivisionAndCombinationInLists;
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

    private List<OutputEntity> generateGreekPhoneNumbersFromStrings(List<String> stringOutputs){
        List<OutputEntity> interpretations=new ArrayList<>();
        for (String stringOutput : stringOutputs) {
            try {
                GreekPhoneNumber number=new GreekPhoneNumber();
                number.setNumber(stringOutput);
                interpretations.add(number);
            } catch (WrongGreekPhoneNumberFormatException e){
                e.printStackTrace();
            }
        }
        return interpretations;
    }


}
