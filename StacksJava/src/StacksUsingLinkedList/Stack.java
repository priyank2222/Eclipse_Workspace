package StacksUsingLinkedList;

public class Stack {
  
  private int capacity;
  LinkedList<Integer> ll;
  
  public Stack(int size)
  {
    this.capacity = size;
    ll =  new LinkedList<>();
  }
  
  public void push(int data)
  {
    ll.enqueue(data);
  }
  
  public int pop()
  {
    return 0;
  }

  public static void main(String[] args) {
    
    Stack stack = new Stack(5);
    
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
  }

}
