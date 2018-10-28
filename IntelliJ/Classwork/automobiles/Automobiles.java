/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobiles;

/**
 *
 * @author BobG_Laptop1
 */
public class Automobiles {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Automobile a1 = new Automobile("Ford", "Blue");
        
        a1.showStatus();

        a1.setLicense("ABC123");
        
        a1.showStatus();
        
        a1.changeColor("Green");
        
        a1.showStatus();
        
        a1.startEngine();
        
        a1.showStatus();
        
        
        
        
        
        
        
        // Automobile[] autos = new Automobile[5];
        
        // autos[0].color = "Red";
        // autos[1].color = "Blue";
        // autos[2].color = "Green";
        // autos[3].color = "Brown";
        // autos[4].color = "Black";
/*        
        for (int i = 0; i < autos.length; i++)
        {
            // autos[i].showStatus();
            
        }
        */
        
        
        
        
        
        
        
        
        
    }
    
}
