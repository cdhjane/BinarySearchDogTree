/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTDogProject;

/**
 *
 * @author Bingnan Dong
 */
public class Dog {
     private String DogName;
    private double Weight;
    public Dog(String DogName, double Weight){
        this.DogName = DogName;
        this.Weight = Weight; 
    }
    
     public String getName(){
        return DogName;
    }
    
    public double getWeight(){
        return Weight;
    }
    
   
    public String toString(){
        return "Dog name is " + this.DogName + " Weight is " + this.Weight;
    }
}
