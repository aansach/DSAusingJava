package assignments;

public class Assignment6 {
    public void driver() {
        CDLL mylist = new CDLL();
        mylist.insertAtStart(10);
        mylist.insertAtLast(20);
        mylist.insertAtLast(30);
        mylist.insertAfter(mylist.search(20), 25);
        mylist.printList();

    }
}

/*
 * write a Java class with the name CDDL , with the instance variables start to
 * hold reference
 * of node type . Define Node as inner class with instance member variables item
 * , prev and next reference
 * variables of type Node. The item variable is to hold data and prev & next are
 * reference variables to refer
 * the previous and next node
 */
class CDLL {
    private Node start;

    public class Node {
        private Node prev;
        private int item;
        private Node next;

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

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

    // Define a method to check if the circular doubly linked list is empty
    public boolean isEmpty() {
        return start == null;
    }

    // Define a method to insert a new node at the beginning of the list
    public void insertAtStart(int data) {
        Node n = new Node();
        n.setItem(data);

        if (start == null) {
            n.setPrev(n);
            n.setNext(n);
            start = n;
        } else {
            n.setNext(start);
            n.setPrev(start.getPrev());
            start.getPrev().setNext(n);
            start.setPrev(n);
            start = n;
        }

    }

    // Define a method to insert a new node at the end of the list
    public void insertAtLast(int data) {
        Node n = new Node();
        n.setItem(data);

        if (start == null) {
            n.setPrev(n);
            n.setNext(n);
            start = n;
        } else {
            n.setNext(start);
            n.setPrev(start.getPrev());
            start.getPrev().setNext(n);
            start.setPrev(n);
        }
    }

    // Define a method to search a node of given item value
    public Node search(int data) {
        Node t;
        t = start;
        if (t == null) {
            return null;
        }
        do {
            if (t.getItem() == data) {
                return t;
            }
            t = t.getNext();
        } while (t != start);
        return null;
    }

    // Define a method to insert a new node after a given node
    public void insertAfter(Node t, int data) {
        if (t != null) {
            Node temp = new Node();
            temp.setItem(data);

            temp.setNext(t.getNext());
            temp.setPrev(t);
            t.getNext().setPrev(temp);
            t.setNext(temp);
        }
    }

    // Define a method to delete first node from the list
    public void deleteFirst() {
        if (start != null) {
            if (start.getNext() == start) {
                start = null;
            } else {
                start.getPrev().setNext(start.getNext());
                start.getNext().setPrev(start.getPrev());
                start = start.getNext();
            }
        }
    }

    // Define a method to delete Last node from the list
    public void deleteLast() {
        if (start != null) {
            if (start.getNext() == start) {
                start = null;
            } else {
                start.getPrev().getPrev().setNext(start);
                start.setPrev(start.getPrev().getPrev());
            }
        }
    }

    /*
     * Define a method to delete a node with given item value . if Multiple nodes of
     * same
     * item value found then delete the first occurrence node
     */
    public void delete(int data) {
        Node t = search(data);
        if (t != null) {
            if (start == t) {
                deleteFirst();
            } else {
                if (start.getPrev() == t) {
                    deleteLast();
                } else {
                    t.getNext().setPrev(t.getPrev());
                    t.getPrev().setNext(t.getNext());
                }
            }
        }
    }

    // print all nodes in the circular doubly linked list
    public void printList() {
        Node t;
        t = start;
        if (t != null) {
            do {
                System.out.print(t.getItem() + " ");
                t = t.getNext();
            } while (t != start);
        }
        System.out.println();
    }
}
