package org.example.models;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Output {


    private List<NumberEntity> outputs;

    protected abstract List<NumberEntity> createAllOutputs(String sequence);

    public final void setOutputs(String sequence){
        this.outputs=createAllOutputs(sequence);
    }


}
