package org.example.models;

import lombok.Getter;

@Getter
public abstract class Input {


    private String value;

    protected abstract String checkValue(String value);

    public final void setValue(String value){
        this.value=checkValue(value);
    }


}
