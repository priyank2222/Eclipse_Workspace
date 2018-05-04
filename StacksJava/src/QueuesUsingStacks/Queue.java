package QueuesUsingStacks;

import StacksUsingArray.*;

public class Queue<E> {
  
  private final static int DEFAULT = 5;
  private int size;
  Stack<E> stack1;
  Stack<E> stack2;
  
  public Queue(int size)
  {
    this.size = size;
    stack1 = new Stack<>(size);
    stack2 = new Stack<>(size);
  }
  
  public Queue()
  {
    this.size = DEFAULT;
    stack1 = new Stack<>(DEFAULT);
    stack2 = new Stack<>(DEFAULT);
  }
  
  public void enqueue(E item)
  {
    try {
      stack1.push(item);
    } catch (FullStackException e) {System.out.println("Queue is Full!!!!");}
  }
  
  public E dequeue() throws EmptyStackException
  {
    while(!stack1.isEmpty())
    {
      try {
        stack2.push(stack1.pop());
      } catch (FullStackException | EmptyStackException e) {e.printStackTrace();}
    }
    return stack2.pop();
  }

  public static void main(String[] args) {
    
    Queue<Integer> queue = new Queue<>(5);
    
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    
    try {
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
    }
    catch(EmptyStackException e) {System.out.println("Queue is Empty!!!!");}
  }

}