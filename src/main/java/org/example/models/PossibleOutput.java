package org.example.models;

import java.util.Queue;

public abstract class PossibleOutput {


    private Queue<SequenceModel> possibleOutputs;

    protected abstract Queue<SequenceModel> createAllPossibleCombinations(Queue<SequenceModel> outputs);

    public final void setPossibleOutputs(Queue<SequenceModel> outputs){
        this.possibleOutputs=createAllPossibleCombinations(outputs);
    }


}
