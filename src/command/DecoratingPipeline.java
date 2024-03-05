package command;

import businessobjects.ClothTemplate;

import java.util.ArrayList;

public class DecoratingPipeline {

    private ArrayList<DecoratingCommand> pipeline = new ArrayList<DecoratingCommand>();

    public void addCommand(DecoratingCommand command) { pipeline.add(command); }
    public ClothTemplate execute(ClothTemplate garment, String option1, String option2){
        ClothTemplate result = garment;
        for(DecoratingCommand command : pipeline){
            result = command.decorate(result, option1, option2);
        }
        return result;
    }

}
