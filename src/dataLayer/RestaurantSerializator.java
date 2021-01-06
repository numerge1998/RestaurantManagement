package dataLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import businessLayer.MenuItem;
import businessLayer.Restaurant;

public class RestaurantSerializator {

	static List<MenuItem> men = new ArrayList<MenuItem>();
public static void ser() {

        
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream("serialization4.ser"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(Restaurant.getMeniu()); 
             
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException ser"); 
        } 
	}

@SuppressWarnings("unchecked")
public static void deser() {
    try { 
    	
        // Reading the object from a file 
        FileInputStream file = new FileInputStream 
                                     ("serialization4.ser"); 
        ObjectInputStream in = new ObjectInputStream 
                                     (file); 

        // Method for deserialization of object 
        
        men = Restaurant.getMeniu() ;
        men = (ArrayList<MenuItem>) in.readObject();
        in.close(); 
        file.close(); 
        System.out.println("Object has been deserialized\n"
                            ); 
        //printdata(Restaurant.getMeniu()); 

        // System.out.println("z = " + object1.z); 
    } 

    catch (IOException ex) { 
        System.out.println("IOException deser"); 
    } 

    catch (ClassNotFoundException ex) { 
        System.out.println("ClassNotFoundException" + 
                            " is caught"); 
    }
}

public static List<MenuItem> getMen() {
	return men;
}

public static void setMen(List<MenuItem> men) {
	RestaurantSerializator.men = men;
}
	
	
}
