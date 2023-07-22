package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumberOutput extends Output {


    @Override
    protected List<NumberEntity> createAllValidOutputs(Input input) {
        List<NumberEntity> outputs=new ArrayList<>();
        SimpleNumber simpleNumber=new SimpleNumber();
        simpleNumber.setNumber(input.getValue());
        outputs.add(simpleNumber);
        return outputs;
    }


}
