package org.example.models;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Queue;

@Getter
@ToString
public abstract class Output {


    private List<OutputEntity> outputs;

    protected abstract List<OutputEntity> createAllValidOutputs(SequenceModel input);

    public final void setOutputs(SequenceModel input){
        this.outputs=createAllValidOutputs(input);
    }


}
