package command;

import businessobjects.ClothTemplate;
import businessobjects.Skirt;
import businessobjects.TShirt;

public class TshirtCommands implements DecoratingCommand{
    
    private TShirt tShirt;
    @Override
    public ClothTemplate decorate(ClothTemplate garment, String neck, String sleeve) {
        tShirt = (TShirt) garment;
        tShirt.setNeck(neckTrimmer(neck));
        tShirt.setSleeve(sleeveTrimmer(sleeve));
        return tShirt;
    }


    public String neckTrimmer(String neck){
        neck = neck.trim();
        neck = neck.toLowerCase();
        neck = neck.substring(0,1).toUpperCase()+neck.substring(1);
        if (tShirt.getAvailableNecks().contains(neck)){
            return neck;
        } else if (neck.equals("Vneck")){
            neck = "V-neck";
        } else if (neck.equals("Uneck")){
            neck = "U-Neck";
        } else if (neck.equals("Cerw")){
            neck = "Crew";
        } else {
            System.out.println("Issue with T-shirt neck, received input =" + neck);
            System.exit(0);
        }

        return neck;
    }

    public String sleeveTrimmer(String sleeve){
        sleeve = sleeve.trim();
        sleeve = sleeve.toLowerCase();
        sleeve = sleeve.substring(0,1).toUpperCase()+sleeve.substring(1);


        if (tShirt.getAvailableSleeves().contains(sleeve)){
            return sleeve;
        } else if (sleeve.equals("Slimed")){
            sleeve = "Slimmed";
        } else if (sleeve.equals("Relaxd")){
            sleeve = "Relaxed";
        } else if (sleeve.equals("Bagy")){
            sleeve = "Baggy";
        } else {
            System.out.println("Issue with T-shirt sleeve, received input =" + sleeve);
            System.exit(0);
        }


        return sleeve;
    }
}
