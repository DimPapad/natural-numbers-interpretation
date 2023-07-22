package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumberOutput extends Output {


    @Override
    protected List<NumberEntity> createAllValidOutputs(String sequence) {
        List<NumberEntity> outputs=new ArrayList<>();
        SimpleNumber simpleNumber=new SimpleNumber();
        simpleNumber.setNumber(sequence);
        outputs.add(simpleNumber);
        return outputs;
    }


}
