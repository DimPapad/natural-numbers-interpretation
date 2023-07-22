package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public abstract class NumberEntity {


    protected static final AtomicInteger count = new AtomicInteger(-2);
    private final int serialNumber;
    private String number;

    public NumberEntity(){
        serialNumber=count.incrementAndGet();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Interpretation ").append(serialNumber).append(": ").append(number);
        return sb.toString();
    }


}