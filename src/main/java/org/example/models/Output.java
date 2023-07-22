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

    public final void setOutputs(String userInput){
        SequenceModel input=new GreekPhoneNumberInput();
        input.setValue(userInput);
        this.outputs=createAllValidOutputs(input);
    }


}
