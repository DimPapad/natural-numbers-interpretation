package org.example.models;

import java.util.Queue;

public abstract class PossibleOutput {


    private Queue<SequenceModel> possibleOutputs;

    protected abstract Queue<SequenceModel> createAllPossibleCombinations(SequenceModel input);

    public final void setPossibleOutputs(SequenceModel input){
        this.possibleOutputs=createAllPossibleCombinations(input);
    }


}
