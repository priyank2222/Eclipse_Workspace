package StacksUsingLinkedList;

public class LinkedList<E> {
  
  private Node<E> head;
  private Node<E> tail;
  
  private static class Node<E>
  {
    private E data;
    Node<E> next;
    
    public Node(E data)
    {
      this.data = data;
      next = null;
    }
  }
  
  public void enqueue(E data)
  {
    Node<E> node = new Node<>(data);
    
    if(head == null)
    {
      this.head = node;
      this.tail = node;
    }
    
    else
    {
      this.tail.next = node;
      this.tail = node;
    }
  }
  
  public E dequeue()
  {
    if(head == null) return null;
    
    E data = head.data;
    head = head.next;
    if(head == null) return null;
    return data;
  }

}
