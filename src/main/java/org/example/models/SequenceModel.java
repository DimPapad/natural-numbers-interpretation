package org.example.models;

public abstract class SequenceModel {


    private String value;

    public abstract void checkValue();

    public final void setValue(String value){
        checkValue();
        this.value=value;
    }


}
