package AlgorithmsUsingStacks;

import StacksUsingArray.*;

public class StackAlgorithms {
  
  
  public static boolean parenthesisMatching(String str)
  {
    int length = str.length();
    Stack<Character> stack = new Stack<>(length);
    String left = "({[";
    String right = ")}]";
    
    for(int i = 0 ; i < length ; i++)
    {
      char ch = str.charAt(i);
      
      if(left.indexOf(ch) >= 0)
      {
        try
        {
          stack.push(ch);
        }
        catch(FullStackException e) {System.out.println("Stack is Full!!!!");}
      }
      else
      {
          if(stack.isEmpty() == true) return false;
          try {
            if(left.indexOf(stack.pop()) != right.indexOf(ch))
              return false;
          } catch (EmptyStackException e) {System.out.println("Stack is Empty!!!!");}
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    
    String str = "{{";
    
    System.out.println(StackAlgorithms.parenthesisMatching(str));

  }

}
