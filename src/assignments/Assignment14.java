package assignments;

import com.sun.source.tree.BreakTree;

public class Assignment14  {
    public void driver(){
        BST bst = new BST();
        bst.insert(50);
        bst.insert(70);
        bst.insert(90);
        bst.insert(60);
        bst.insert(65);
        bst.insert(70);
        bst.insert(40);
        bst.insert(20);
        bst.insert(30);
        bst.inOrder();
        System.out.println();
        bst.delete(70);
        bst.inOrder();
    }
}
/*
Define a class BST(Binary Search Tree) with Node type reference variable
root as member variable , implement Binary Search Tree  using linked representation
 */
class BST{
    private Node root;

    public class Node{
        Node left;
        int item ;
        Node right;
    }
    // Define a method to check if the tree is empty
    public boolean isEmpty(){
        return  root ==null;
    }
    // Define a method to insert a new element in the BST
    public void insert(int data ){
        Node n = new Node();
        Node ptr=null;
        n.left=null;
        n.item = data;
        n.right=null;
        if(isEmpty()){
            root=n;
        }else{
            ptr=root;
            //unless explicitly said BST doesn't allow duplicate values
            while(n.item!=ptr.item){
                if(n.item< ptr.item){// Left Subtree
                    if(ptr.left!=null){
                        ptr=ptr.left;
                    }else{
                        ptr.left=n;
                        break;
                    }
                }else{// Right Subtree
                    if(ptr.right!=null){
                        ptr=ptr.right;
                    }else {
                        ptr.right=n;
                        break;
                    }

                }
            }


        }
    }
    public void postOrderRec(Node ptr){
        if(ptr!=null){
            postOrderRec(ptr.left);
            postOrderRec(ptr.right);
            System.out.print(" "+ptr.item);
        }
    }
    // Define a method for postorder traversing in BST
    public void postOrder(){
        postOrderRec(root);
    }

    public void preOrderRec(Node ptr){
        if(ptr!=null){
            System.out.print(" "+ptr.item);
            preOrderRec(ptr.left);
            preOrderRec(ptr.right);
        }
    }
    //Define a method for preOrder traversing in BST
    public void preOrder(){
        preOrderRec(root);
    }

    public void inOrderRec(Node ptr){
        if(ptr!=null){
            inOrderRec(ptr.left);
            System.out.print(" "+ptr.item);
            inOrderRec(ptr.right);
        }
    }
    // Define a method for inOrder traversing in BSt
    public void inOrder(){
        inOrderRec(root);
    }

    // Define a method to search an item in the BST
    public Node search (int data){
        Node ptr ;
        ptr=root;
        while(ptr!=null){
            if(ptr.item==data){
                return ptr;
            }
            if(data<ptr.item){
                ptr=ptr.left;
            }else{
                ptr=ptr.right;
            }

        }
        return null;

    }
    public Node deleteNode(Node ptr, int data){
        if(ptr==null){
            return null;
        }
        if(data<ptr.item){
            ptr.left=deleteNode(ptr.left, data);
        } else if (data > ptr.item) {
            ptr.right=deleteNode(ptr.right,data);
        }else{
            if(ptr.left==null&& ptr.right==null){
                return null;
            }
            if(ptr.left==null || ptr.right==null){
                Node child =ptr.left!=null?ptr.left:ptr.right;
                return child;
            }
             // Two childern
            Node pred, parpred;
            parpred=ptr;
            pred=ptr.left;
            while(pred.right!=null){
                parpred=pred;
                pred=pred.right;
            }
            ptr.item= pred.item;
            if(parpred.right==pred){
                parpred.right=deleteNode(pred,pred.item);
            }else if(parpred.left==pred){
                parpred.left=deleteNode(pred, pred.item);

            }
        }
        return  ptr;
    }
    // Define a method to delete an element form BST
    public void delete(int data ){
        root=deleteNode(root , data );
    }


}