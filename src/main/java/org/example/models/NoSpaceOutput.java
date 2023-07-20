package org.example.models;

public class NoSpaceOutput extends SequenceModel{


    @Override
    protected String checkValue(String value) {
        return value.replaceAll("\\s+", "");
    }


}
