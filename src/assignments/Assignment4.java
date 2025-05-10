package assignments;

public class Assignment4 {
    public void driver() {
        DLL myList = new DLL();
        myList.insertAtFirst(10);
        myList.insertAtLast(20);
        myList.insertAtLast(30);
        myList.insertAfter(myList.search(20), 25);
        myList.printList();
        myList.deleteFirst();
        myList.printList();
    }
}

/*
 * Write a Java class with the name DLL , with the instance variables start to
 * hold
 * reference of type node . Define Node as inner class with instance member
 * variables
 * item , prev and next reference variables of type node.The item variable is to
 * hold
 * data and prev & next are the reference variables to refer the previous and
 * next node.
 * Also define setters and getters in Node class
 */
class DLL {
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

    // Define a method to check if the doubly linked list is empty
    public boolean isEmpty() {
        return start == null;
    }

    // Define a method to insert a new node at the beginning of the list
    public void insertAtFirst(int data) {
        Node n = new Node();
        n.setItem(data);
        n.setPrev(null);
        n.setNext(start);
        if (start != null) {
            start.setPrev(n);
        }
        start = n;
    }

    // Define a method to insert a new node at the end of the list
    public void insertAtLast(int data) {
        Node n = new Node();
        n.setItem(data);
        n.setNext(null);
        if (start == null) {
            n.setPrev(null);
            start = n;
        } else {
            Node temp = new Node();
            temp = start;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            n.setPrev(temp);
            temp.setNext(n);
        }
    }

    // Define a method to search a node of the given item value
    public Node search(int data) {
        Node t;
        t = start;
        while (t != null) {
            if (t.getItem() == data) {
                return t;
            }
            t = t.getNext();
        }
        return null;
    }

    // Define a method to insert a new node after a given node
    public void insertAfter(Node t, int data) {
        if (t != null) {
            Node n = new Node();
            n.setItem(data);

            n.setNext(t.getNext());
            n.setPrev(t);

            if (t.getNext() != null) {
                t.getNext().setPrev(n);

            }
            t.setNext(n);
        }
    }

    // Define a method to delete first node of the list
    public void deleteFirst() {
        if (start != null) {
            if (start.getNext() == null) {
                start = null;
            } else {
                start.getNext().setPrev(null);
                start = start.getNext();
            }
        }
    }

    // Define a method to delete last node of the list
    public void deleteLast() {
        if (start != null) {
            if (start.getNext() == null) {
                start = null;
            } else {
                Node temp = new Node();
                temp = start;
                while (temp.getNext().getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(null);

            }
        }
    }

    // Define a method to delete a node with given item value . if multiple nodes of
    // same item value
    // found then delete the first occurence node
    public void deleteNode(int data) {
        Node t;
        t = search(data);
        if (t != null) {
            if (start == null) {
                deleteFirst();
            }
        } else {
            Node temp;
            temp = t.getPrev();
            if (t.getNext() != null) {
                t.getNext().setPrev(temp);
            }
            temp.setNext(t.getNext());
        }
    }

    // Define a method to print all the items in the doubly linked list

    public void printList() {
        Node t;
        t = start;
        while (t != null) {
            System.out.print(t.getItem() + " ");
            t = t.getNext();
        }
        System.out.println();
    }
}