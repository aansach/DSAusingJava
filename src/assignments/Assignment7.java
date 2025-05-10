package assignments;

public class Assignment7 {
    public void driver() {

        Stack s = new Stack(4);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.peek());

    }
}

/*
 * Define a class Stack with top and ptr as member variables. The
 * member variable to contains the index of last filled block of the
 * array and ptr refer to the array
 */
class Stack {
    private int top;
    private int[] ptr;

    // Define a paramaterized constructor to initialize member variables with
    // the given size of the stack
    public Stack(int size) {
        ptr = new int[size];
        top = -1;
    }

    // Define a method to push a new element on to the Stack
    public void push(int data) {
        try {
            ptr[top + 1] = data;
            top++;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Stack Overflow ");
        }
    }

    // Define a method to peek top element of the stack
    public int peek() {
        int x = 0;
        try {
            x = ptr[top];
        } catch (Exception e) {
            System.out.println("Stack is Empty ");
        }
        return x;
    }

    // Define a method to pop the top element of the Stack
    public int pop() {
        int x = 0;
        try {
            x = ptr[top];
            top--;
        } catch (Exception e) {
            System.out.println("stack is Empty i.e Stack underflow ");
        }
        return x;
    }

    // Define a method to check the stack overflow
    public boolean isFull() {
        return top == ptr.length - 1;
    }

    // Define a method to check the stack underflow
    public boolean isEmpty() {
        return top == -1;
    }
}