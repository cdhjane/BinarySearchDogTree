/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTDogProject;



/**
 *
 * @author 
 */
public class BinarySearchDogTree {
    
    class Node
    {
        Dog data;
        Node leftChild;
        Node rightChild;
       
        Node(Dog data)
        {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
   
    private Node root;
    private String criteria;
    
    public BinarySearchDogTree()
    {
        root = null;
    }  
    
    public void switchSortCriteria(String criteria){
    this.criteria = criteria;
    this.root = null;
}
     
    public boolean addDog(String name, double weight){
     if(containsDog(name)){
       System.out.println( "Dog with name " + name+  " already exists" );
       return false;
     }
     else{
       Dog dog = new Dog(name, weight);
       Node newNode = new Node(dog);
       if (criteria.compareTo("name") == 0){
             root = addRecursiveByName(root, dog);
         }
       if (criteria.compareTo("weight") == 0){
              root = addRecursiveByWeight(root, dog); 
         }
        return true;
     } 
   }
   
   
    private Node addRecursiveByName(Node current, Dog data)
    {
         
        //int comp = current.data.getName().compareTo(data.getName());
        if (current == null)  //valid leaf node to add our new node to
        {
            return new Node(data);
        }
        else if (data.getName().compareTo(current.data.getName()) < 0)
        {
            current.leftChild = addRecursiveByName(current.leftChild, data);
            return current;
        }
        else if (data.getName().compareTo(current.data.getName()) > 0)
        {
            current.rightChild = addRecursiveByName(current.rightChild, data);
            return current;
        }
        else //it already exists
        {
            return current;
        }
    }
 
  private Node addRecursiveByWeight(Node current, Dog data)
    {
        if (current == null)  //valid leaf node to add our new node to
        {
            return new Node(data);
        }
        else if ( data.getWeight() < current.data.getWeight()  )
        {
            current.leftChild =addRecursiveByWeight(current.leftChild, data);
            return current;
        }
        else if (data.getWeight() > current.data.getWeight()  )
        {
            current.rightChild = addRecursiveByWeight(current.rightChild, data);
            return current;
        }
        else //it already exists
        {
            return current;
        }
    }  
    
  public boolean containsDog(String name)
  {
        return containsDogRecursive(root, name);
   }
   
  private boolean containsDogRecursive(Node currentNode, String name)
  {
        if (currentNode == null)
        {
            return false;
        }
        else if (name.compareTo(currentNode.data.getName()) == 0)
        {
            return true;
        }
        else if (name.compareTo(currentNode.data.getName())< 0)
        {
           
            return containsDogRecursive(currentNode.leftChild, name);
        }
        else 
        {
            return containsDogRecursive(currentNode.rightChild, name);
        }
    }
  

public void displayInOrder()
    {
        inOrderTraversal(root);
    }
   
  private void inOrderTraversal(Node node)
  {
        if (node != null)
        {
            inOrderTraversal(node.leftChild);
            System.out.println(String.format("%-16s%-10s ",node.data.getName(),node.data.getWeight()));
            inOrderTraversal(node.rightChild);
        }
    }
  
   public boolean removeDog(String name){
     if (!containsDog(name))  
           return false;
     else{
        root= removeDogRecursive(root, name);
        return true;
     }
   }
   
   private Dog getSmallestDog(Node node)
   {
        if (node.leftChild == null)
        {
            return node.data;
        }
        else
        {
            return getSmallestDog(node.leftChild);
        }
    }
   
   private Node removeDogRecursive(Node currentNode,String name)
    {
        
        if (currentNode == null)
            return null;
        else if (name.compareTo(currentNode.data.getName()) == 0)  //found node to delete
        {          
                  
           //CASE 1: Node has no Children
            if (currentNode.leftChild == null && currentNode.rightChild == null)
            {
                
                return null;
            }
            //CASE 2: Node has 1 child
            else if (currentNode.rightChild == null)
            {
            
                return currentNode.leftChild;
            }
            else if (currentNode.leftChild == null)
            {
              
                return currentNode.rightChild;
            }
            //CASE 3: Node has 2 children
            else                            
            {
                //Step 1) find smallest value S in right subtree of Node
                Dog smallestDog = getSmallestDog(currentNode.rightChild);
                
                //Step 2) Replace Node's value with S's value
                currentNode.data = smallestDog;
                
                //Step 3) Delete S from right subtree
                currentNode.rightChild = removeDogRecursive(currentNode.rightChild, smallestDog.getName());
                return currentNode;
            }
        }
        else if (name.compareTo(currentNode.data.getName()) <0)
        {
            currentNode.leftChild = removeDogRecursive(currentNode.leftChild, name);
            return currentNode;     
        }
        else
        {
            currentNode.rightChild = removeDogRecursive(currentNode.rightChild, name);
            return currentNode;
        }

    }
   
 
  public double getDogWeight(String name)
  {
        return getDogWeightRecursive(root, name);
   }
   
  private double  getDogWeightRecursive(Node currentNode, String name)
  {
      
       if (currentNode == null)
        {
            return -1;
        }
        else if (name.compareTo(currentNode.data.getName()) == 0)
        {
          
            return currentNode.data.getWeight();
        }
        else if (name.compareTo(currentNode.data.getName())< 0)
        {
           
            return getDogWeightRecursive(currentNode.leftChild, name);
        }
        else 
        {  
            return  getDogWeightRecursive(currentNode.rightChild, name);
        }
    }
}
