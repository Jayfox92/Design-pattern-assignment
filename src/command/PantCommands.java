package command;

import businessobjects.ClothTemplate;
import businessobjects.Pants;

public class PantCommands implements DecoratingCommand {
    private Pants pants;

    @Override
    public ClothTemplate decorate(ClothTemplate garment, String fit, String length) {
        pants = (Pants) garment;
        pants.setFit(fittingTrimmer(fit));
        pants.setLength(lengthTrimmer(length));
        return pants;
    }

    public String fittingTrimmer(String fit){
        fit = fit.trim();
        fit = fit.toLowerCase();
        fit = fit.substring(0,1).toUpperCase()+fit.substring(1);
        if (pants.getAvailableFits().contains(fit)){
            return fit;
        } else if (fit.equals("Slimfit")){
            fit = "Slim fit";
        } else if (fit.equals("Relaxedfit")){
            fit = "Relaxed fit";
        } else if (fit.equals("Regularfit")){
            fit = "Regular fit";
        } else {
            System.out.println("Issue with pants fitting, received input =" + fit);
            System.exit(0);
        }

        return fit;
    }

    public String lengthTrimmer(String length){
        length = length.trim();
        length = length.toLowerCase();
        length = length.substring(0,1).toUpperCase()+length.substring(1);


        if (pants.getAvailableLengths().contains(length)){
            return length;
        } else if (length.equals("Nobreak")){
            length = "No break";
        } else if (length.equals("Slightbreak")){
            length = "Slight break";
        } else if (length.equals("Halfbreak")){
            length = "Half break";
        } else {
            System.out.println("Issue with pants length, received input =" + length);
            System.exit(0);
        }


        return length;
    }
}
