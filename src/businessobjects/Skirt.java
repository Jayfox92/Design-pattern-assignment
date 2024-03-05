package businessobjects;

import java.util.ArrayList;
import java.util.List;

public class Skirt extends ClothTemplate {
    private String waistline;
    private String pattern;
    private short price = 65;

    private ArrayList<String> availableWaistlines = new ArrayList<String>(List.of("Straight","Stretch","Wrap"));
    private ArrayList<String> availablePatterns = new ArrayList<String>(List.of("Circle","Tiered","Sarong"));


    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        String oldWaist = this.waistline;
        this.waistline = waistline;
        this.propertyChangeSupport.firePropertyChange("waist", oldWaist, waistline);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        String oldPattern = this.pattern;
        this.pattern = pattern;
        this.propertyChangeSupport.firePropertyChange("pattern", oldPattern, this.pattern);
    }
    public ArrayList<String> getAvailableWaistlines() {
        return availableWaistlines;
    }

    public void setAvailableWaistlines(ArrayList<String> availableWaistlines) {
        this.availableWaistlines = availableWaistlines;
    }

    public ArrayList<String> getAvailablePatterns() {
        return availablePatterns;
    }

    public void setAvailablePatterns(ArrayList<String> availablePatterns) {
        this.availablePatterns = availablePatterns;
    }

    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }
}
