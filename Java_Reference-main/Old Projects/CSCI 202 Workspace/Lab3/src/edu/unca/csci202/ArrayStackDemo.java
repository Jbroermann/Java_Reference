package edu.unca.csci202;
public class ArrayStackDemo {
    public static void main(String[] args) {
        //demo a stack of String objects
        ArrayStack<String> stringStack = new ArrayStack();
        System.out.println(stringStack);
        System.out.println("push one");
        stringStack.push("one");
        System.out.println("push two");
        stringStack.push("two");
        System.out.println(stringStack);
        System.out.println("pop");
        stringStack.pop();
        System.out.println(stringStack);
        System.out.println("peek="+stringStack.peek());
        System.out.println(stringStack);
        System.out.println("push three");
        stringStack.push("three");
        System.out.println("push four");
        stringStack.push("four");
        System.out.println(stringStack);
        while (!stringStack.isEmpty()) {
            System.out.println("pop");
            stringStack.pop();
            System.out.println(stringStack);
        }
        try {
            stringStack.pop();
        } catch (EmptyCollectionException e) {
            System.out.println("successfully caught empty collection exception");
        }
    }
}
