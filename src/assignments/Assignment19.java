package assignments;
import java.util.Scanner;
public class Assignment19 {
    public void driver(){
        GraphList g = new GraphList();
        g.createGraph(5);
        g.printGraph();
    }
}
/*
Define a Class Graph to implement linked list Representation of Graph
Define needful inner class for node and inner class for AdjList
 */
// Define appropriate Constructors in the classes in the AdjList and graph
// Define appropriate methods to manage linked list in AdjList
// Define createGraph() method in Graph class to allocate memory for array of AdjList Objects;
// Define a method addEdge() in Graph to add new node in Adjacency List .
// Define a method to print graph (print values of adjacency list );
class GraphList{

    private int vCount;
    private AdjList[] arr;
    public GraphList(){
        vCount=0;
        arr=null;
    }

    public int getvCount() {
        return vCount;
    }
    Scanner sc = new Scanner(System.in);
    public void createGraph(int vno){
        int n , v , data ;
        vCount=vno;

        arr=new AdjList[vCount];
        for(int i=0; i<vCount;i++){
            arr[i]=new AdjList();
            arr[i].setVertex(i);
            System.out.println("How many adjacent nodes of V"+i+":");
            n=sc.nextInt();
            for(int j=0;j<n;j++){
                System.out.println("Enter vertex no : ");
                v=sc.nextInt();
                System.out.println("Enter data to store: ");
                data =sc.nextInt();
                arr[i].addNode(v,data);
            }
        }
    }

    public void printGraph(){
        for(int i=0 ; i<vCount; i++){
            System.out.println();
            arr[i].printList();
        }
    }

    public class Node{
        int item;
        int vertex;
        Node  next;

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

// Define appropriate methods to manage linked list in adj list
    public class AdjList{
        private Node start;
        private int vertex ;
    // Below code can be removed as default values is null only
    // In Java  reference variable is by default null
        public AdjList(){
            start=null;
        }
        public AdjList(int v){
            vertex=v;
            start=null;
        }
        public Node getStart(){
            return start;
        }
        public void setVertex(int v ){
            vertex= v;
        }
        public void addNode(int v , int data ){
            Node n =new Node();
            n.setItem(data);
            n.setVertex(v);
            n.setNext(start);
            start=n;
        }
        public void removeFirstNode(){
            if(start!=null){
                start=start.getNext();
            }
        }
        public void printList(){
            Node t =start;
            while(t!=null){
                System.out.print(" ("+t.getVertex()+","+t.getItem()+")");
                t=t.getNext();
            }
        }
    }
}

// Without Spring Boot, setting up a basic RESTful API requires manual configuration.

