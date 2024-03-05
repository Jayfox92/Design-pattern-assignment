package command;

import businessobjects.ClothTemplate;
import businessobjects.Pants;
import businessobjects.Skirt;

public class SkirtCommands implements DecoratingCommand{
    
    private Skirt skirt;

    @Override
    public ClothTemplate decorate(ClothTemplate garment, String waistline, String pattern) {
        skirt = (Skirt) garment;
        skirt.setWaistline(waistTrimmer(waistline));
        skirt.setPattern(patternTrimmer(pattern));
        return skirt;
    }


    public String waistTrimmer(String waist){
        waist = waist.trim();
        waist = waist.toLowerCase();
        waist = waist.substring(0,1).toUpperCase()+waist.substring(1);
        if (skirt.getAvailableWaistlines().contains(waist)){
            return waist;
        } else if (waist.equals("Straigt")||waist.equals("Straiht")){
            waist = "Straight";
        } else if (waist.equals("Stretch")){
            waist = "Stretched";
        } else if (waist.equals("Wrap")){
            waist = "Wrap";
        } else {
            System.out.println("Issue with skirt waistline, received input =" + waist);
            System.exit(0);
        }

        return waist;
    }

    public String patternTrimmer(String pattern){
        pattern = pattern.trim();
        pattern = pattern.toLowerCase();
        pattern = pattern.substring(0,1).toUpperCase()+pattern.substring(1);


        if (skirt.getAvailablePatterns().contains(pattern)){
            return pattern;
        } else if (pattern.equals("Circle")){
            pattern = "Circled";
        } else if (pattern.equals("Tired")){
            pattern = "Tiered";
        } else if (pattern.equals("Sargong")){
            pattern = "Sarong";
        } else {
            System.out.println("Issue with skirt pattern, received input =" + pattern);
            System.exit(0);
        }


        return pattern;
    }
    
    
}
