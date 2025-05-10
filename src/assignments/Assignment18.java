package assignments;

import java.util.Scanner;
public class Assignment18 {
    public void driver(){

    }
}
/*
Define a class Graph using matrix representation with v_count ,
e_count  and adj pointer as instance members
 */
class Graph{
    private  int vCount , eCount;
    private int[][]adj;

    //In Question 1 define a method createGraph()  to
    // create and store adjacent node information
    public void createGraph(int vno, int eno){
        int u , v ;
        vCount=vno;
        eCount=eno;
        adj = new int [vCount][eCount];
        // Below code can be removed as default values are 0 only
        for(int i=0; i<vCount; i++){
            for(int j =0; j<vCount; j++){
                adj[i][j]=0;
            }
        }
        Scanner sc= new Scanner(System.in);
        // Remove till here
        for(int k =1;k<=eCount;k++){
            System.out.println("Enter node numbers connecting edge:");
            u=sc.nextInt();
            v=sc.nextInt();
            adj[u][v]=1;
            adj[v][u]=1;
        }
    }

    //In Question 1 , define a method to print graph matrix

    public void printMatrix(){
        System.out.println();
        for(int i=0; i<vCount; i++){
            for(int j=0; j<vCount;j++){
                System.out.print(adj[i][j]+"  ");
                System.out.println();
            }
        }
    }

    // In Question 1 , Define a matrix to print all the adjacent matrix of the given node

    public void printAdjacentNodes(int v){
        if(v<vCount&&v>=0){
            for(int i =0;i<vCount;i++){
                if(adj[v][i]==1){
                    System.out.println("V "+i);
                }
            }
        }
    }

    // In Question 1 , define a method to check if a given node is isolated or not
    public boolean isIsolated(int v){
        boolean flag =true;
        if (v < vCount && v >= 0) {
            for(int i=0; i<vCount;i++){
                if(adj[v][i]==1){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

}