import java.util.*;

public class StackDemo{
  public static void main(String[] args) {
    Stack stack=new Stack();
    stack.push(new Integer(10));
    stack.push("a");
    System.out.println("The contents of Stack is" + stack);
    System.out.println("The size of an Stack is" + stack.size());
    System.out.println("The number poped out is" + stack.pop());
    System.out.println("The number poped out is " + stack.pop());
    //System.out.println("The number poped out is" + stack.pop());
    System.out.println("The contents of stack is" + stack);
    System.out.println("The size of an stack is" + stack.size());
  }
}