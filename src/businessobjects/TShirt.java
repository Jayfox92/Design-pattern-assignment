package businessobjects;

import java.util.ArrayList;
import java.util.List;

public class TShirt extends ClothTemplate {
    private String sleeve;
    private String neck;
    private short price = 25;

    private ArrayList<String> availableSleeves = new ArrayList<String>(List.of("Slim","Relaxed","Baggy"));
    private ArrayList<String> availableNecks = new ArrayList<>(List.of("V-neck","U-neck","Crew neck"));


    public String getSleeve() {
        return sleeve;
    }

    public void setSleeve(String sleeve) {
        String oldSleeve = this.sleeve;
        this.sleeve = sleeve;
        propertyChangeSupport.firePropertyChange("neck", oldSleeve, this.sleeve);
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        String oldNeck = this.neck;
        this.neck = neck;
        this.propertyChangeSupport.firePropertyChange("neck", oldNeck, this.neck);
    }

    public ArrayList<String> getAvailableSleeves() {
        return availableSleeves;
    }

    public void setAvailableSleeves(ArrayList<String> availableSleeves) {
        this.availableSleeves = availableSleeves;
    }

    public ArrayList<String> getAvailableNecks() {
        return availableNecks;
    }

    public void setAvailableNecks(ArrayList<String> availableNecks) {
        this.availableNecks = availableNecks;
    }

    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }
}
