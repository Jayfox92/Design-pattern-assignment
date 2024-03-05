package webshopui;

import businessobjects.ClothTemplate;
import businessobjects.Pants;
import businessobjects.Skirt;
import businessobjects.TShirt;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

public class OrderPlacement {
    private Class type;
    private Pants pants;
    private Skirt skirt;
    private TShirt tshirt;
    private String sizeChoice;
    private String materialChoice;
    private String colorChoice;
    private String fitChoice;
    private String lengthChoice;
    private String sleeveChoice;
    private String neckChoice;
    private String waistlineChoice;
    private String patternChoice;
    private String customerName;
    private String customerAddress;
    private String customerEmail;

    private int price;
    private Scanner scanner;
    private String separator = "------";
    private PropertyChangeSupport propertyChangeSupport;
    private boolean confirmedOrder;
    public OrderPlacement() {
        scanner = new Scanner(System.in);
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void welcomeMsg(){
        System.out.println("------Welcome to Wigell's clothing shop!------");
        firstMenu();
    }

    public void firstMenu(){
        System.out.println(separator);
        System.out.println("What would you like to order?");
        System.out.println("1. Pants");
        System.out.println("2. Skirts");
        System.out.println("3. T-shirts");
        System.out.println("9. Exit the shop");
        switch (scanner.nextInt()) {
            case 1: type = Pants.class; pants = new Pants(); secondMenu(pants); break;
            case 2: type = Skirt.class; skirt = new Skirt(); secondMenu(skirt); break;
            case 3: type = TShirt.class; tshirt = new TShirt(); secondMenu(tshirt); break;
            case 9: System.exit(0);
            default:
                System.out.println("Wrong input, enter only a digit according to the menu");

        }


    }

    public void secondMenu(ClothTemplate cloth){
        scanner.nextLine();

        System.out.println(separator);
        System.out.println("Choose a material:");
        for (String material: cloth.getAvailableMaterials()){
            System.out.print(material + ", ");
        }
        System.out.println();
        materialChoice = scanner.nextLine();


        System.out.println(separator);
        System.out.println("Choose a size:");
        for (String size: cloth.getAvailableSizes()){
            System.out.print(size + ", ");
        }
        System.out.println();
        sizeChoice = scanner.nextLine();


        System.out.println(separator);
        System.out.println("Choose a color:");
        for (String color: cloth.getAvailableColors()){
            System.out.print(color + ", ");
        }
        System.out.println();
        colorChoice = scanner.nextLine();



        if (type == Pants.class) {
            pantsMenu();
        } else if (type == Skirt.class) {
            skirtMenu();
        } else tshirtMenu();



    }

    public void pantsMenu(){
        System.out.println(separator);
        System.out.println("Choose a fitting");
        for(String fit:pants.getAvailableFits()){
            System.out.print(fit+", ");
        }
        System.out.println();
        fitChoice = scanner.nextLine();

        System.out.println(separator);
        System.out.println("Choose a length:");
        for(String length:pants.getAvailableLengths()){
            System.out.print(length+", ");
        }
        System.out.println();
        lengthChoice = scanner.nextLine();


        checkout();

    }
    public void skirtMenu(){
        System.out.println(separator);
        System.out.println("Choose a waistline");
        for(String waistline:skirt.getAvailableWaistlines()){
            System.out.print(waistline+", ");
        }
        System.out.println();
        waistlineChoice = scanner.nextLine();

        System.out.println(separator);
        System.out.println("Choose a pattern:");
        for(String pattern:skirt.getAvailablePatterns()){
            System.out.print(pattern+", ");
        }
        System.out.println();
        patternChoice = scanner.nextLine();


        checkout();
    }
    public void tshirtMenu(){
        System.out.println(separator);
        System.out.println("Choose a sleeve");
        for(String sleeve:tshirt.getAvailableSleeves()){
            System.out.print(sleeve+", ");
        }
        System.out.println();
        sleeveChoice = scanner.nextLine();

        System.out.println(separator);
        System.out.println("Choose a neck:");
        for(String neck: tshirt.getAvailableNecks()){
            System.out.print(neck+", ");
        }
        System.out.println();
        neckChoice = scanner.nextLine();


        checkout();
    }

    public void checkout(){
        System.out.println(separator);
        System.out.println("Enter your name:");
        customerName = scanner.nextLine();
        System.out.println(separator);
        System.out.println("Enter your address:");
        customerAddress = scanner.nextLine();
        System.out.println(separator);
        System.out.println("Enter your e-mail:");
        customerEmail = scanner.nextLine();
        System.out.println(separator);

        if (type == Pants.class) {
            price = pants.getPrice();
        } else if (type == Skirt.class) {
            price = skirt.getPrice();
        } else price = tshirt.getPrice();

        System.out.println("Your total cost will be "+price+ " , if this is OK, type 'yes' below");
        if (scanner.nextLine().equalsIgnoreCase(("yes"))) {
            System.out.println(separator);
            System.out.println("All done, thank you for your order!");
            System.out.println(separator);
            setConfirmedOrder(true);

        }else System.out.println("Something went wrong, try again");
        scanner.close();



    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }


    public Class getType() {
        return type;
    }

    public String getSizeChoice() {
        return sizeChoice;
    }

    public String getMaterialChoice() {
        return materialChoice;
    }

    public String getColorChoice() {
        return colorChoice;
    }

    public String getFitChoice() {
        return fitChoice;
    }

    public String getLengthChoice() {
        return lengthChoice;
    }

    public String getSleeveChoice() {
        return sleeveChoice;
    }

    public String getNeckChoice() {
        return neckChoice;
    }

    public String getWaistlineChoice() {
        return waistlineChoice;
    }

    public String getPatternChoice() {
        return patternChoice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean isConfirmedOrder() {
        return confirmedOrder;
    }

    public void setConfirmedOrder(boolean confirmedOrder) {
        boolean oldState = this.confirmedOrder;
        this.confirmedOrder = confirmedOrder;
        if(this.confirmedOrder){
            this.propertyChangeSupport.firePropertyChange("new", oldState, confirmedOrder);
        }
    }

    public String getSeparator() {
        return separator;
    }
}
