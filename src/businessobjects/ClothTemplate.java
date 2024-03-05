package businessobjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ClothTemplate implements Serializable {
    private int id;
    private String name;
    private String size;
    private String material;
    private String color;
    private boolean finalizedGarment;

    private ArrayList<String> availableSizes = new ArrayList<>(List.of("Medium","Large"));
    private ArrayList<String> availableMaterials = new ArrayList<>(List.of("Jeans","Cotton"));
    private ArrayList<String> availableColors = new ArrayList<>(List.of("Blue","Red"));
    protected PropertyChangeSupport propertyChangeSupport;

    public ClothTemplate(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    public ClothTemplate(int id,
                         String name,
                         String size,
                         String material,
                         String color)
    {
        this.id = id;
        this.name = name;
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<String> getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(ArrayList<String> availableSizes) {
        this.availableSizes = availableSizes;
    }

    public ArrayList<String> getAvailableMaterials() {
        return availableMaterials;
    }

    public void setAvailableMaterials(ArrayList<String> availableMaterials) {
        this.availableMaterials = availableMaterials;
    }

    public ArrayList<String> getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(ArrayList<String> availableColors) {
        this.availableColors = availableColors;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public boolean isFinalizedGarment() {
        return finalizedGarment;
    }

    public void setFinalizedGarment(boolean finalizedGarment) {
        boolean oldState = this.finalizedGarment;
        this.finalizedGarment = finalizedGarment;
        propertyChangeSupport.firePropertyChange("done", oldState, finalizedGarment);
    }
}
