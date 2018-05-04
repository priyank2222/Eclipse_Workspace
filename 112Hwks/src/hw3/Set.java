/*
 * Student First Name:
 * Student Last Name:
 * Student BU Number:
 * Purpose: 
 */

package hw3;


public class Set  {
    
    private int SIZE = 20;  // length of the array
    
    private int[] S;              // array holding the set
    
    private int next;             // pointer to next available slot in array
    
    
    public Set() {
        // your code here
    }
    
    public Set(int[] A) {
        // your code here
    }
    
    public Set clone() {
        // your code here
        return this;   // just to get it to compile; replace this with something appropriate   
    }
    
    // This method reallocates the array S to twice as big and copies all the elements over.
    // It is called only by insert.
    
    private void resize() {
        int[] T = new int[SIZE * 2];
        for(int i = 0; i < S.length; ++i) {
            T[i] = S[i];
        }
        SIZE = SIZE * 2;
        S = T;
    }
        
    public  String toString()  {
        // your code here
        return null;   // just to get it to compile; replace null with something appropriate    
    } 
     
    public int size() {
        // your code here
        return 0;   // just to get it to compile; replace 0 with something appropriate    
    }
    
    public  boolean isEmpty() {
        // your code here
        return false;   // just to get it to compile; replace false with something appropriate   
    }
      
    public boolean member(int k) {
        // your code here
        return false;   // just to get it to compile; replace false with something appropriate   
    }    
   
    public  boolean subset(Set T) {
        // your code here
        return false;   // just to get it to compile; replace false with something appropriate   
    }
    
    public  boolean equal(Set T) {
        // your code here
        return false;   // just to get it to compile; replace false with something appropriate   
    }
       
    public void insert(int k) {
        // your code here
    }
    
    public void delete(int k) {
        // your code here
    }
  
    public Set union(Set T) {
        // your code here
        return null;   // just to get it to compile; replace null with something appropriate   
    }
   
    public Set intersection(Set T) {
        // your code here
        return null;   // just to get it to compile; replace null with something appropriate   
    }
    
    public Set setdifference(Set T) {
        // your code here
        return null;   // just to get it to compile; replace null with something appropriate   
    }
      
}
