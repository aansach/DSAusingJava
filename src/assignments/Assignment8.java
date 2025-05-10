package assignments;

public class Assignment8 {
    public void driver() {
        StackList s = new StackList();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.peek());
        s.reverse();
        System.out.println(s.peek());
        StackList s1 = StackList.reverseStack(s);
        System.out.println(s1.peek());
    }
}

/*
 * Define a class Stack with Node type reference variable top as an instance
 * member
 * . Also define inner class Node with member variables item and next in order
 * to
 * implement stack using linked list
 */
class StackList {
    private Node top;

    class Node {
        private int item;
        private Node next;

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Define a method to push a new element on to the stack
    public void push(int data) {
        Node n = new Node();
        n.setItem(data);
        n.setNext(top);
        top = n;
    }

    // Define a method to peek top element of the stack
    public int peek() {

        int x = 0;
        try {
            x = top.getItem();

        } catch (NullPointerException e) {
            System.out.println("List is Empty ");
        }
        return x;
    }

    // Define a method to pop the top element of the stack
    public int pop() {
        int x = 0;
        try {
            x = top.getItem();
            top = top.getNext();
        } catch (NullPointerException e) {
            System.out.println("List is Empty");
        }
        return x;
    }

    // Define a method to check if the stack is Empty
    public boolean isEmpty() {
        return top == null;
    }

    // Define a method to reverse a stack
    public void reverse() {
        StackList temp = new StackList();

        while (!isEmpty()) {
            temp.push(pop());

        }
        StackList t = new StackList();

        while (!temp.isEmpty()) {
            t.push(temp.pop());

        }

        while (!t.isEmpty()) {
            push(t.pop());

        }

    }
    /*
     * public void reverse() {
     * StackList temp = new StackList();
     * while (!isEmpty()) {
     * temp.push(pop());
     * }
     * // Now top of temp is reversed compared to the original
     * top = temp.top; // Reassign top of the original stack to the reversed stack
     * }
     */

    // another method using static
    public static StackList reverseStack(StackList s) {
        StackList temp = new StackList();
        while (!s.isEmpty()) {
            temp.push(s.pop());
        }
        return temp;
    }
}
