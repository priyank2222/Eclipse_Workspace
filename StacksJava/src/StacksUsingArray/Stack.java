package StacksUsingArray;

public class Stack<E> {
  
  private final static int DEFAULT_SIZE = 5;
  private int top;
  private E[] items;
  private int size;
  
  public Stack(int size)
  {
    items = (E[])new Object[size];
    top = -1;
    this.size = size;
  }
  
  public Stack()
  {
    items = (E[])new Object[DEFAULT_SIZE];
    top = -1;
    this.size = DEFAULT_SIZE;
  }
  
  public void push(E item) throws FullStackException
  {
    if(top == this.size - 1)
      throw new FullStackException();
    top++;
    items[top] = item;
  }
  
  public E pop() throws EmptyStackException
  {
    if(top == -1)
      throw new EmptyStackException();
    E item = items[top];
    top--;
    return item;
  }
  
  public boolean isEmpty()
  {
    
    if(top == -1)
      return true;
    
    else
      return false;
  }
}
