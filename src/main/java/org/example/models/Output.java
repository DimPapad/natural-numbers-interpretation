package org.example.models;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Output {


    private List<NumberEntity> outputs;

    protected abstract List<NumberEntity> createAllValidOutputs(Input input);

    public final void setOutputs(String userInput){
        Input input=new NumberInput();
        input.setValue(userInput);
        this.outputs=createAllValidOutputs(input);
    }


}
