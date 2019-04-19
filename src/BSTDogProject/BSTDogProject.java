package BSTDogProject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author 
 */
public class BSTDogProject {
    public static void main(String[] args) {
        // TODO code application logic here
      BinarySearchDogTree t = new BinarySearchDogTree();
      t.switchSortCriteria("name");
     
      ArrayList<Dog> dog = new ArrayList<Dog>();
     
   
      dog.add(new Dog("John",10.1));
      dog.add(new Dog("Smith",10.2));
      dog.add(new Dog("Eve",14.3));
      dog.add(new Dog("Ada",8.1));
      dog.add(new Dog("Eric",9.1));
      dog.add(new Dog("Eric2",19.1));
      dog.add(new Dog("Eric3",29.1));
      dog.add(new Dog("Eric4",39.1));
      dog.add(new Dog("Eric6",59.1));
      
      for ( int i = 0 ; i< dog.size(); i++){
       t.addDog(dog.get(i).getName(),dog.get(i).getWeight() );   
      }
     System.out.println("Sort by name:");
     t.displayInOrder();
     
    t.switchSortCriteria("weight");
    for(int i = 0 ; i< dog.size(); i++){
       t.addDog(dog.get(i).getName(),dog.get(i).getWeight());
     }
     System.out.println("\nSort by weight:");
     t.displayInOrder();
     
     
    }
}
