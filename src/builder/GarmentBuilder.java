package builder;

import businessobjects.ClothTemplate;


public class GarmentBuilder<T extends ClothTemplate> {
    private T garment;

    public GarmentBuilder<T> setType(Class<T> type){
        try {
            garment = type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public GarmentBuilder addSize(String size){
        size = trimmer(size);
        if (garment.getAvailableSizes().contains(size)) {
            garment.setSize(size);
        } else {
            System.out.println("Error in setting size, input tried ="+size);
            System.exit(0);
        }

        return this;
    }

    public GarmentBuilder addMaterial(String material){
        material = trimmer(material);
        if (garment.getAvailableMaterials().contains(material)){
            garment.setMaterial(material);
        }else {
            System.out.println("Error in setting material, input tried ="+material);
            System.exit(0);
        }

        return this;
    }

    public GarmentBuilder addColor(String color){
        color = trimmer(color);
        if (garment.getAvailableColors().contains(color)){
            garment.setColor(color);
        } else {
            System.out.println("Error in setting color, input tried ="+color);
            System.exit(0);
        }

        return this;
    }

    public T build(){

        return garment;

    }

    public String trimmer(String string){
        String string1 = string.trim();
        String string2 = string1.toLowerCase();
        String string3 = string2.substring(0,1).toUpperCase()+string2.substring(1);
        return string3;

    }


}
