package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class NumberEntity {


    protected static int count = -1;
    private final int serialNumber;
    private String number;

    public NumberEntity(){
        this.serialNumber=NumberEntity.count++;
    }

    @Override
    public String toString() {
        return "Interpretation " +
                serialNumber + ": " +
                number;
    }


}