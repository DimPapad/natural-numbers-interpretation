package org.example.models;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;

import java.util.*;

public class GreekPhoneNumberOutput extends Output{


    @Override
    protected List<NumberEntity> createAllValidOutputs(Input input) {
        List<String> inputSubStrings=new ArrayList<>(Arrays.asList(input.getValue().split("\\s+")));
        List<List<String>> subStringsFromDivision=generateSubStringsFromDivision(inputSubStrings);
        List<List<String>> subStringsFromCombination=generateSubStringsFromCombination(inputSubStrings);
        List<List<String>> subStringsFromDivisionAndCombination=combineSubStringsFromDivisionAndCombination(subStringsFromDivision, subStringsFromCombination);

        List<String> permutations=new ArrayList<>();
        generatePermutations(subStringsFromDivisionAndCombination, permutations, 0, "");

        List<NumberEntity> interpretations=generateGreekPhoneNumbersFromStrings(permutations);

        return interpretations;
    }

    private List<List<String>> generateSubStringsFromDivision(List<String> subStrings){
        List<List<String>> subStringsFromDivision=new ArrayList<>();
        for (String subString : subStrings) {
            List<String> subStringDivisions=new ArrayList<>();
            subStringDivisions.add(subString);
            switch (subString.length()){
                case 2:
                    if (Integer.parseInt(subString)>=20 && subString.charAt(1) != '0') {
                        subStringDivisions.add(subString.charAt(0) + "0" + subString.charAt(1));
                    }
                    break;
                case 3:
                    subStringDivisions.add(subString.charAt(0)+"00"+subString.substring(1,3));
                    if (Integer.parseInt(subString.substring(1,3))>=20 && subString.charAt(2) != '0') {
                        subStringDivisions.add(subString.charAt(0) + "00" + subString.charAt(1)+ "0" + subString.charAt(2));
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
                    if (Integer.parseInt(subStrings.get(i))>=20 && subStrings.get(i).charAt(1) == '0' && subStrings.get(i+1).length()==1) {
                        subStringCombinations.add(subStrings.get(i));
                        subStringCombinations.add(subStrings.get(i).substring(0,1));
                    }
                    else {
                        subStringCombinations.add(subStrings.get(i));
                    }
                    break;
                case 3:
                    if (subStrings.get(i).startsWith("00", 1)) {
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

    private List<NumberEntity> generateGreekPhoneNumbersFromStrings(List<String> stringOutputs){
        List<NumberEntity> interpretations=new ArrayList<>();
        for (String stringOutput : stringOutputs) {
            try {
                GreekPhoneNumber greekPhoneNumber=new GreekPhoneNumber();
                greekPhoneNumber.setNumber(stringOutput);
                interpretations.add(greekPhoneNumber);
            } catch (WrongGreekPhoneNumberFormatException e){
                NumberEntity.count.decrementAndGet();
                SimpleNumber simpleNumber=new SimpleNumber();
                simpleNumber.setNumber(stringOutput);
                interpretations.add(simpleNumber);
            }
        }
        return interpretations;
    }


}
