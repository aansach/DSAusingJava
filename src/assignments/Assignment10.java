package assignments;

public class Assignment10 {
    public void driver() {
        QueueList q = new QueueList();
        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(40);
        q.insert(50);
        System.out.println("Total Elements: " + q.countItems());
        System.out.println("Front Item: " + q.getFrontItem());
        System.out.println("Rear Item: " + q.getRearItem());
        System.out.println();
        q.delete();
        System.out.println("Total Elements: " + q.countItems());
        System.out.println("Front Item: " + q.getFrontItem());
        System.out.println("Rear Item: " + q.getRearItem());
        System.out.println();
    }
}

/*
 * Define a class Queue with Node type reference variables front
 * and rear as member variables . implement queue using singly linked list
 */
class QueueList {
    private Node front;
    private Node rear;
    private int count;

    public class Node {
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

    // Define a Constructor to initialize a member variable
    public QueueList() {
        // they are by default null
        // why the question is saying to initialize the member variable
        // user defined member and static variables are by default null in java
        front = null;
        rear = null;
        count = 0;
    }

    // Define a method to insert a new element at the rear in the queue
    public void insert(int data) {
        Node n = new Node();
        n.setItem(data);
        n.setNext(null);
        if (front == null && rear == null) {
            front = n;
            rear = n;
        } else {
            rear.setNext(n);
            rear = n;
        }
        count++;
    }

    // Define a method to view rear element in the queue
    public int getRearItem() {
        if (rear == null) {
            throw new ArithmeticException("Empty Queue");
        }
        return rear.getItem();
    }

    // Define a method to view front element in the queue
    public int getFrontItem() {
        if (front == null) {
            throw new ArithmeticException("Empty Queue");
        }
        return front.getItem();
    }

    // Define a method to delete the front element of the queue
    public void delete() {
        if (front == null) {
            throw new ArithmeticException("Empty Queue Cannot delete");
        }
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        // optional method after line 78
        // else if (front == rear) {
        // front=null;
        // rear=null;
        //
        // }else{
        // front=front.getNext();
        // }

        count--;
    }

    // Define a method to check whether Queue is empty or not
    public boolean isEmpty() {
        return front == null;
    }

    // Define a method to count number of elements present in the queue
    public int countItems() {
        return count;
    }

}