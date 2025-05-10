package assignments;

public class Assignment9 {
    public void driver() {
        Queue Q = new Queue(5);
        Q.insert(10);
        Q.insert(20);
        Q.insert(30);
        Q.insert(40);
        System.out.println("Total items: " + Q.countItems());
        System.out.println("Rare Item: " + Q.getRearItem());
        System.out.println("Front Item: " + Q.getFrontItem());
        Q.delete();
        System.out.println();
        System.out.println("Total items: " + Q.countItems());
        System.out.println("Rare Item: " + Q.getRearItem());
        System.out.println("Front Item: " + Q.getFrontItem());
        Q.insert(50);
        Q.insert(60);
        System.out.println();
        System.out.println("Total items: " + Q.countItems());
        System.out.println("Rare Item: " + Q.getRearItem());
        System.out.println("Front Item: " + Q.getFrontItem());
    }

}

/*
 * Define a Class Queue with front , rear and ptr reference as member variables
 * .
 * Impplement queue using array
 */
class Queue {
    private int front;
    private int rear;
    private int[] ptr;

    // Define a parameterized constructor to initialise member variables .
    public Queue(int size) {
        ptr = new int[size];
        front = -1;
        rear = -1;

    }

    // Define a method to check queue overflow
    public boolean isFull() {
        return rear + 1 == front || front == 0 && rear == ptr.length - 1;

    }

    // Define a method to check queue underflow
    public boolean isEmpty() {
        return front == -1 && rear == -1;

    }

    // Define a method to insert a new element at the rear in the queue .
    public void insert(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
            ptr[rear] = data;

        } else if (rear + 1 == ptr.length) {
            rear = 0;
            ptr[rear] = data;
        } else {
            rear++;
            ptr[rear] = data;
        }

    }

    // Define a method to view Front element of the queue
    public int getFrontItem() {
        try {
            return ptr[front];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Queue is Empty");
        }
        return -1;
    }

    // Define a method to view Rear element of the queue
    public int getRearItem() {
        try {
            return ptr[rear];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Queue is Empty");
        }
        return -1;
    }

    // Define a method to delete the front element of the queue
    public void delete() {
        if (isEmpty()) {
            System.out.println("Queue UnderFlow");
        } else if (front == rear) {
            front = -1;
            rear = -1;
        }
        if (front == ptr.length - 1) {
            front = 0;

        } else {
            front++;
        }
    }

    // Define a method to count number of elements present in the queue
    public int countItems() {
        if (isEmpty()) {
            return -1;
        } else if (front <= rear) {
            return rear - front + 1;
        } else {
            return (ptr.length - (front - rear)) + 1;
        }
    }

}
