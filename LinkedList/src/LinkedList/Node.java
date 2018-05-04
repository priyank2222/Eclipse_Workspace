package LinkedList;

public class Node {
  
  protected int data;
  protected Node next;
  
  public Node(int data)
  {
    this.data = data;
    this.next = null;
  }
  
  public static void main(String args[])
  {
    Node first = new Node(1);
    Node second = new Node(2);
    Node last = new Node(3);
    
    first.next = second;
    second.next = last;
    
    System.out.println("Printing LinkedList Normally");
    LinkedListAlgorithms.printElementsOfLinkedList(first);
    System.out.println("-------------");
    System.out.println("Printing LinkedList using Recursion");
    LinkedListAlgorithms.LinkedListPrintUsingRecursion(first);
    System.out.println("-------------");
    System.out.println("Printing LinkedList using Recursion in Reverse Order");
    LinkedListAlgorithms.LinkedListReversePrintUsingRecursion(first);
    System.out.println("-------------");
    System.out.println("Reversing LinkedList");
    LinkedListAlgorithms.LinkedListPrintUsingRecursion(LinkedListAlgorithms.ReverseLinkedList(first));
    System.out.println("-------------");
    LinkedListAlgorithms.addNodeatPosition(first, 2 , 50);
    
  }

}
