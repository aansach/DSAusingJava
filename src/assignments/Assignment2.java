package assignments;

import java.awt.image.AreaAveragingScaleFilter;

public class Assignment2 {
    public void driver (){
        DynArray  arr = new DynArray();
        arr.append(10);
        arr.append(20);
        arr.append(30);
        arr.append(40);
        arr.append(50);
        for(int i=0; i<arr.count();i++){
            System.out.print(arr.getValue(i)+" ");
        }
        System.out.println("Capacity ="+arr.getCapacity());
        arr.delete(2);
        for(int i=0; i<arr.count();i++){
            System.out.print(arr.getValue(i)+" ");
        }
        System.out.println("Capacity ="+arr.getCapacity());
    }
}
/*
Write a Java class with the name DynArray, with instance variables lastIndex to
hold the index of last filled block of Array  and ptr as a reference to an array
 */
class DynArray{
    private int lastIndex;
    private int[] ptr;
    public DynArray(){
        lastIndex =-1;
        ptr=new int[1];
    }
    // Define a constructor in DynArray class which takes size of an array
    // as an argument and allocates memory for the array
    public DynArray(int size){
         lastIndex=-1;
        ptr=new int[size];

    }
    // Define a method to double the size of an array
    void doubleArray(){
        if (lastIndex+1==ptr.length){
            int[] temp=new int[ptr.length*2];
            for(int i =0;i<=lastIndex;i++){
                temp[i]=ptr[i];
            }
            ptr=temp;
            /*yesma last index update gareko xaina kina bhane
             yesma just ptr ko reference matra change gareko ho
             kunai value append , delete , insert gareko haina*/
        }
    }
    // Define a method to half the size of an array
    void halfArray(){
        int[] temp = new int[ptr.length/2];
        for (int i=0 ; i<=lastIndex; i++){
            temp[i]=ptr[i];
        }
        ptr=temp;
    }
    // Define a method to append data in an array
    public void append(int data){
        if(isFull()){
            doubleArray();
        }
        ptr[lastIndex+1]=data;
        lastIndex++;
    }
    //Define a method to insert data in an array
    public void insert (int index , int data ){
       try {
           if(index<0 || index>lastIndex+1){
               throw new ArrayIndexOutOfBoundsException("Invalid Index ");
           }
           if(isFull()) {
               doubleArray();
           }
           for(int i=lastIndex; i>=index;i--){
               ptr[i+1]=ptr[i];
           }
           lastIndex++;
           ptr[index]=data;
       }catch (ArrayIndexOutOfBoundsException e){
           System.out.println(e.getMessage());
       }
    }
    //Define a method to edit array element of given index
    public void edit(int index , int newData){
        try {
            if(index<0 || index>index+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index");
            }
            ptr[index]=newData;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    //Define a method to delete an element form the array at given index
    public void delete(int index ){
        try{
            if(index<0 ||index>lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index");
            }
            for(int i=index ; i<lastIndex; i++){
                ptr[i]=ptr[i+1];
            }
            lastIndex--;
            // delete gari sake paxi array lai check garne
            // half hunxa ki nai
            if(ptr.length>1 &&lastIndex+1==ptr.length/2){
                halfArray();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    // Define a method to get total number of elements present in the array
    public int count (){
        return  lastIndex+1;
    }
    // Define a method to check whether an array is empty or not
    public int getValue(int index){
        try{
            if(index<0 || index>lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index");
            }
            return ptr[index];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    //Define a method to get capacity of the array
    public int getCapacity(){
        return ptr.length;
    }
    // Define a method to check the array is full or not
    // check garnu ko kunai matlab xaina as Dynamic array is growable
    public boolean isFull(){
        return  lastIndex+1==ptr.length;
    }
    // Define a method to check the array is empty or not
    public boolean isEmpty(){
        return lastIndex==-1;
    }
}