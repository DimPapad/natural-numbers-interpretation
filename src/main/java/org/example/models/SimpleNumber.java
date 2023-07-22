package org.example.models;

public class SimpleNumber extends NumberEntity implements NoSpace{


    public void setNumber(String number){
        number=removeSpaces(number);
        super.setNumber(number);
    }

    @Override
    public String removeSpaces(String value) {
        return value.replaceAll("\\s+", "");
    }


}
