package org.example.models;

public class SimpleNumber extends NumberEntity implements NoSpace{


    public void setNumber(Input input){
        String number=removeSpaces(input.getValue());
        super.setNumber(number);
    }

    @Override
    public String removeSpaces(String value) {
        return value.replaceAll("\\s+", "");
    }


}
