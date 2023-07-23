package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

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
        final StringBuffer sb = new StringBuffer();
        sb.append("Interpretation ").append(serialNumber).append(": ").append(number);
        return sb.toString();
    }


}