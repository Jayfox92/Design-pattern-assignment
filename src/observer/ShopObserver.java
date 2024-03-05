package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShopObserver implements PropertyChangeListener {
    private String separator = "------";
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if (evt.getPropertyName().equals("new")){
            System.out.println("New order confirmed, initializing factory and notifying CEO");
            System.out.println(separator);

        } else if (evt.getPropertyName().equals("fit")){
            System.out.println("A pair of pants in the factory has been decorated with: "+evt.getNewValue());
            System.out.println(separator);
        }else if (evt.getPropertyName().equals("length")){
        System.out.println("A pair of pants in the factory has been decorated with: "+evt.getNewValue());
            System.out.println(separator);
        } else if (evt.getPropertyName().equals("waist")){
            System.out.println("A skirt in the factory has been decorated with: "+evt.getNewValue());
            System.out.println(separator);
        } else if (evt.getPropertyName().equals("pattern")){
            System.out.println("A skirt in the factory has been decorated with: "+evt.getNewValue());
            System.out.println(separator);
        } else if (evt.getPropertyName().equals("neck")){
            System.out.println("A t-shirt in the factory has been decorated with: "+evt.getNewValue());
            System.out.println(separator);
        } else if (evt.getPropertyName().equals("sleeve")){
            System.out.println("A t-shirt in the factory has been decorated with: "+evt.getNewValue());
            System.out.println(separator);
        }
         else if (evt.getPropertyName().equals("done")){
            System.out.println("A garment has been completed in the factory");
            System.out.println(separator);
        }
    }
}
