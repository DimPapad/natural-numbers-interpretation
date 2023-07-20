package org.example.models;

import java.util.List;
import java.util.Queue;

public abstract class Output {


    private List<String> outputs;

    protected abstract List<String> createAllValidOutputs(SequenceModel input);

    public final void setPossibleOutputs(SequenceModel input){
        this.outputs=createAllValidOutputs(input);
    }


}
