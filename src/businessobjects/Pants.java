package businessobjects;


import java.util.ArrayList;
import java.util.List;

public class Pants extends ClothTemplate {
    private String fit;
    private String length;
    private short price = 85;
    private ArrayList<String> availableFits = new ArrayList<>(List.of("Slim fit","Relaxed fit","Regular fit"));
    private ArrayList<String> availableLengths = new ArrayList<>(List.of("No break","Slight break","Half break"));



    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        String oldFit = this.fit;
        this.fit = fit;
        this.propertyChangeSupport.firePropertyChange("fit",oldFit, this.fit);
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        String oldLength = this.length;
        this.length = length;
        this.propertyChangeSupport.firePropertyChange("length",oldLength, this.length);
    }

    public ArrayList<String> getAvailableFits() {
        return availableFits;
    }

    public void setAvailableFits(ArrayList<String> availableFits) {
        this.availableFits = availableFits;
    }

    public ArrayList<String> getAvailableLengths() {
        return availableLengths;
    }

    public void setAvailableLengths(ArrayList<String> availableLengths) {
        this.availableLengths = availableLengths;
    }

    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }
}
