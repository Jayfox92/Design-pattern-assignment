import builder.GarmentBuilder;
import businessobjects.*;
import command.DecoratingPipeline;
import command.PantCommands;
import command.SkirtCommands;
import command.TshirtCommands;
import observer.ShopObserver;
import webshopui.OrderPlacement;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ShopObserver shopObserver = new ShopObserver();
        OrderPlacement orderPlacement = new OrderPlacement();
        orderPlacement.addPropertyChangeListener(shopObserver);
        orderPlacement.welcomeMsg();


        GarmentBuilder builder = new GarmentBuilder();

        Class<ClothTemplate> type = orderPlacement.getType();

        ClothTemplate garment = null;
        try {
            garment = builder
                    .setType(type)
                    .addMaterial(orderPlacement.getMaterialChoice())
                    .addSize(orderPlacement.getSizeChoice())
                    .addColor(orderPlacement.getColorChoice())
                    .build();
        } catch (Exception e) {e.printStackTrace();}


        Map<ClothTemplate, Customer> customerOrders = new HashMap<>();

        Customer customer = new Customer();
        customer.setName(orderPlacement.getCustomerName());
        customer.setAddress(orderPlacement.getCustomerAddress());
        customer.setEmail(orderPlacement.getCustomerEmail());

        customerOrders.put(garment, customer);


        DecoratingPipeline pipeline = new DecoratingPipeline();

        if (garment instanceof Pants pants){
            pants.addPropertyChangeListener(shopObserver);
            pipeline.addCommand(new PantCommands());
            pants = (Pants) pipeline.execute(garment, orderPlacement.getFitChoice(), orderPlacement.getLengthChoice());

            if (pants.getMaterial() != null && pants.getSize() != null && pants.getColor() != null && pants.getFit() != null && pants.getLength() != null){
                pants.setFinalizedGarment(true);
            }



            System.out.println("Order details below");
            System.out.println(orderPlacement.getSeparator());
            System.out.print("Material: "+pants.getMaterial());
            System.out.print(", Size: "+pants.getSize());
            System.out.print(", Color: "+pants.getColor());
            System.out.print(", Fitting: "+pants.getFit());
            System.out.println(", Length: "+pants.getLength());
            System.out.println(orderPlacement.getSeparator());
            System.out.println("Order belongs to customer:");
            Customer customer1 = customerOrders.get(pants);
            System.out.println(customer1.getName()+", "+customer1.getAddress()+", "+customer1.getEmail());
            System.out.println("Customer pays: "+pants.getPrice()+ " dollarydoos");


        } else if (garment instanceof Skirt skirt){
            skirt.addPropertyChangeListener(shopObserver);
            pipeline.addCommand(new SkirtCommands());
            skirt = (Skirt) pipeline.execute(garment, orderPlacement.getWaistlineChoice(), orderPlacement.getPatternChoice());

            if (skirt.getMaterial() != null && skirt.getSize() != null && skirt.getColor() != null && skirt.getWaistline() != null && skirt.getPattern() != null){
                skirt.setFinalizedGarment(true);
            }


            System.out.println("Order details below");
            System.out.println(orderPlacement.getSeparator());
            System.out.print("Material: "+skirt.getMaterial());
            System.out.print(", Size: "+skirt.getSize());
            System.out.print(", Color: "+skirt.getColor());
            System.out.print(", Fitting: "+skirt.getWaistline());
            System.out.println(", Length: "+skirt.getPattern());
            System.out.println(orderPlacement.getSeparator());
            System.out.println("Order belongs to customer:");
            Customer customer1 = customerOrders.get(skirt);
            System.out.println(customer1.getName()+", "+customer1.getAddress()+", "+customer1.getEmail());
            System.out.println("Customer pays: "+skirt.getPrice());
        } else if (garment instanceof TShirt tShirt){
            tShirt.addPropertyChangeListener(shopObserver);
            pipeline.addCommand(new TshirtCommands());
            tShirt = (TShirt) pipeline.execute(garment, orderPlacement.getNeckChoice(), orderPlacement.getSleeveChoice());

            if (tShirt.getMaterial() != null && tShirt.getSize() != null && tShirt.getColor() != null && tShirt.getNeck() != null && tShirt.getSleeve() != null){
                tShirt.setFinalizedGarment(true);
            }


            System.out.println("Order details below");
            System.out.println(orderPlacement.getSeparator());
            System.out.print("Material: "+tShirt.getMaterial());
            System.out.print(", Size: "+tShirt.getSize());
            System.out.print(", Color: "+tShirt.getColor());
            System.out.print(", Fitting: "+tShirt.getNeck());
            System.out.println(", Length: "+tShirt.getSleeve());
            System.out.println(orderPlacement.getSeparator());
            System.out.println("Order belongs to customer:");
            Customer customer1 = customerOrders.get(tShirt);
            System.out.println(customer1.getName()+", "+customer1.getAddress()+", "+customer1.getEmail());
            System.out.println("Customer pays: "+tShirt.getPrice());
        }



    }
}
