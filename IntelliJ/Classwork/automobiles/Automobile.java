/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobiles;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author BobG_Laptop1
 */

public class Automobile {

    protected String make;
    protected String color;
    protected String license = "not assigned";
    protected boolean engineState = false;
    protected Instant start;
    protected Instant timeNow;
    protected long timeRunning = 0;
    
    public Automobile(String m, String c)
    {
        make = m;
        color = c;        
    }
    
    void startEngine()
    {
        if (engineState == true)
        {
            System.out.println("The engine is already on.");
        }
        else
        {
            engineState = true;
            start = Instant.now();
            System.out.println("The engine is now on.");
        }
    }
    
    void setLicense(String s1)
    {
        license = s1;         
    }
    
    void changeColor (String c)
    {
        color = c;
    }
    
    void showStatus()
    {
        System.out.println("This automobile is a " + color + " " + make + " ");
        System.out.println("The license plate for this car is " + license);
        if (engineState == true)
        {
            System.out.println("The engine is on.");
            timeNow = Instant.now();
            Duration timeElapsed = Duration.between(start, timeNow);
            System.out.println("The engine has been on for: " + timeElapsed.toMillis()+ " milliseconds");
        }
        else 
            System.out.println("The engine is off.");
    }
}
