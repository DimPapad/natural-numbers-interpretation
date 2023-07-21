package org.example.models;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;

import java.util.*;

public class GreekPhoneNumberOutput extends Output{


    @Override
    protected List<OutputEntity> createAllValidOutputs(SequenceModel input) {
        List<String> inputSubStrings=new ArrayList<>(Arrays.asList(input.getValue().split("\\s+")));
        List<List<String>> subStringsFromDivision=new ArrayList<>();
        List<List<String>> subStringsFromCombination=new ArrayList<>();
        List<String> permutationsFromDivision=new ArrayList<>();
        List<String> permutationsFromCombination=new ArrayList<>();
        List<OutputEntity> interpretations=new ArrayList<>();

        generateSubStringsFromDivision(inputSubStrings, subStringsFromDivision);
        generateSubStringsFromCombination(inputSubStrings, subStringsFromCombination);

        generatePermutations(subStringsFromDivision, permutationsFromDivision, 0, "");
        generatePermutations(subStringsFromCombination, permutationsFromCombination, 0, "");
        // COMMON PERMUTATIONS NEEDED

        generateGreekPhoneNumbersFromStrings(permutationsFromDivision,interpretations);
        generateGreekPhoneNumbersFromStrings(permutationsFromCombination,interpretations);

        return interpretations;
    }

    private void generateSubStringsFromDivision(List<String> subStrings, List<List<String>> target){
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
            target.add(subStringDivisions);
        }
    }

    private void generateSubStringsFromCombination(List<String> subStrings, List<List<String>> target){
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
                    if (subStrings.get(i).substring(1, 3).equals("00") && subStrings.get(i+1).length()==2) {
                        subStringCombinations.add(subStrings.get(i));
                        subStringCombinations.add(subStrings.get(i).substring(0,1));
                    }
                    else if (subStrings.get(i).substring(1, 3).equals("00") && subStrings.get(i+1).length()==1) {
                        subStringCombinations.add(subStrings.get(i));
                        subStringCombinations.add(subStrings.get(i).substring(0,2));
                    }
                    else {
                        subStringCombinations.add(subStrings.get(i));
                    }
                    break;
                default:
                    subStringCombinations.add(subStrings.get(i));
            }
            target.add(subStringCombinations);
        }
        target.add(new ArrayList<String>(Arrays.asList(subStrings.get(subStrings.size()-1))));
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

    private void generateGreekPhoneNumbersFromStrings(List<String> stringOutputs, List<OutputEntity> target){
        for (String stringOutput : stringOutputs) {
            try {
                GreekPhoneNumber number=new GreekPhoneNumber();
                number.setNumber(stringOutput);
                target.add(number);
            } catch (WrongGreekPhoneNumberFormatException e){
                e.printStackTrace();
            }
        }
    }


}
