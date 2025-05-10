package assignments;

public class Assignment3 {
    public void driver(){
        SLL myList = new SLL();
        myList.insertAtStart(10);
        myList.insertAtLast(20);
        myList.insertAfter(myList.search(10), 15);
        myList.printList();
        myList.deleteNode(10);
        myList.printList();
    }
}
/*
Write a Java class with the name SLL , with the instance variables start
to hold reference of type node . Define Node as inner class with item and
and next instance member variables . The item variable is to hold data and
next is a reference variable to refer the next node .Also define setters
and getters in Node class
 */
class SLL{
    private Node start;
    public  class Node{
        private int item ;
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

    // Define a method to check if the linked list is empty
    public boolean isEmpty(){
        return start==null;
    }
    // Define a method to insert a new node at the beginning of the list
    public void insertAtStart(int data ){
        Node n = new Node();
        n.setItem(data);
        n.setNext(start);
        start=n;
    }
    // Define a method to insert a new node at the end of the list
    public void insertAtLast(int data){
        Node n = new Node();
        n.setItem(data);
        n.setNext(null);
        Node t ;
        if(start==null ){
            start=n;
        }else{
            t=start;
            while(t.getNext()!=null){
                t=t.getNext();
            }
            t.setNext(n);
        }
    }
    // Define a method to search a node of given item value
    public Node search(int data){
        Node t;
        t=start;
        while(t!=null){
            if(t.getItem()==data){
                return  t;
            }
            t=t.getNext();

        }
        return  null;
    }
    // Define a method to insert a new node after a given node
    public void insertAfter(Node t , int data ){
        if(t !=null){
            Node n = new Node();
            n.setItem(data);
            n.setNext(t.getNext());
            t.setNext(n);
        }
    }
    // Define a method to delete first node of the list
    public void deleteFirst(){
        if(start!=null){
            start=start.getNext();
        }else{
            System.out.println("List is empty");
        }
    }
    // Define a method to delete last node of the list
    public void deleteLast(){

        if(start==null){
            System.out.println("List is Empty");
        }else if(start.getNext()==null){
            start=null;
        }else{
            Node t;
            t=start;
            while (t.getNext().getNext()!=null){
                t=t.getNext();
            }
            t.setNext(null);
        }
    }
    /*
    Define a method to delete a node with given item value .
    If , multiple nodes of same item value found then delete the
    first occurence node.
     */
    public void deleteNode(int data){
      Node t=  search(data);
      if(t==null){
          System.out.println("No such item found ");
      }else{
          if(t==start)
              deleteFirst();
          else{
              Node temp;
              temp=start;
              while (temp.getNext()!=t){
                  temp=temp.getNext();
              }
              temp.setNext(t.getNext());
          }
      }
    }
    public void printList(){
        Node t;
        t=start;
        while(t!=null){
            System.out.print(t.getItem()+"  ");
            t=t.getNext();
        }
        System.out.println();
    }
}