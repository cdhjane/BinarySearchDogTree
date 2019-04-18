/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTDogProject;

/**
 *
 * @author Dell
 */
public class Hello {
    /**
* Method to return a greeting.
* @return The String "Hello"
*/
   public String speak() {
    //TODO: Add code to compute result
    return "Hello";
   }
   public static int largest(int[] list) {
    int largest = list[0];
    for (int i = 1; i < list.length; i++) {
    if (largest < list[i]) {
      largest = list[i];
    }
  }
    return largest;
    }
}

