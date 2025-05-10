package assignments;

public class Assignment5 {
    public void driver() {

        CLL mylist = new CLL();
        mylist.insertAtStart(10);
        mylist.insertAtLast(20);
        mylist.insertAfter(mylist.search(20), 30);
        mylist.printList();
    }
}

/*
 * Write a Java Class with the name CLL , with the instance variables last to
 * hold reference
 * of type node , Define Node as inner class with item and next instance member
 * variables. The
 * item variable is to hold data and next is a reference variable to refer the
 * next node .
 * Also Define setters and getters in Node Class
 */
class CLL {
    private Node last;

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

    // Define a method to check if the circular linked list is empty
    public boolean isEmpty() {
        return last == null;
    }

    // Define a method to insert a new node at the beginning of the list
    public void insertAtStart(int data) {
        Node n = new Node();

        n.setItem(data);
        if (last == null) {
            n.setNext(n);
            last = n;
        } else {
            n.setNext(last.getNext());
            last.setNext(n);
        }
    }

    // Define a method to insert a new node at the end of the list
    public void insertAtLast(int data) {
        Node n = new Node();
        n.setItem(data);

        if (last == null) {
            n.setNext(n);
        } else {
            n.setNext(last.getNext());
            last.setNext(n);
        }
        last = n;
    }

    // Define a method to search a Node of given item value
    public Node search(int data) {
        try {
            Node t = new Node();
            t = last;
            do {
                if (t.getItem() == data) {
                    return t;
                }
                t = t.getNext();

            } while (t != last);
            return null;
        } catch (NullPointerException e) {
            return null;
        }

    }

    // Define a method to insert a new Node after a given node
    public void insertAfter(Node t, int data) {
        if (t != null) {
            Node n = new Node();
            n.setItem(data);
            n.setNext(t.getNext());
            t.setNext(n);
            if (t == last) {
                last = n;
            }
        }
    }

    // Define a method to delete first node form the list
    public void deleteFirst() {

        if (last != null) {
            if (last.getNext() == last) {
                last = null;
            } else {
                last.setNext(last.getNext().getNext());
            }
        }
    }

    // Define a method to delete last node form the list
    public void deleteLast() {

        if (last != null) {
            if (last.getNext() == last) {
                last = null;
            } else {
                Node t;
                t = last.getNext();
                while (t.getNext() != last) {
                    t = t.getNext();
                }
                t.setNext(last.getNext());
                last = t;
            }
        }
    }

    /*
     * Define a method to delete a node with given item value.
     * if multiple nodes of same item value found then delete
     * the first occurrence node
     */
    public void delete(int data) {
        Node t = search(data);
        if (t != null) {
            if (last.getNext() == null) {
                last = null;
            } else {
                if (t == last) {
                    deleteLast();
                } else {
                    Node temp;
                    temp = last.getNext();
                    while (temp.getNext() != t) {
                        temp = temp.getNext();

                    }
                    temp.setNext(t.getNext());
                }
            }
        }
    }

    // print all the items in the circular linked list
    public void printList() {
        Node t;
        t = last.getNext();
        do {
            System.out.print(t.getItem() + " ");
            t = t.getNext();
        } while (t != last.getNext());
        System.out.println();
    }

}
