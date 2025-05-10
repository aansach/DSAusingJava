package assignments;

public class Assignment1 {
    public void driver(){
    Array arr = new Array(4);
    arr.append(10);
    arr.append(20);
    arr.insert(0,30);
    arr.insert(1,40);
    arr.append(50);
    for(int i=0; i<arr.count();i++){
        System.out.println(arr.getValue(i));
    }
    }

}
/*
Write a Java class with the name Array, with instance variables lastIndex
to hold the index of last filled block of Array and ptr as a reference to an
array.
 */
class Array{
    private int lastIndex;
    private int [] ptr;
    //Define a constructor in Array class which takes size of an array as an
    //argument and allocates memory for the array
    public Array(int size ){
        lastIndex=-1;
        ptr=new int[size];
    }
    // Define a method to append data in an array
    public void append(int data){
        try{
            ptr[lastIndex+1]=data;
            lastIndex++;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array is full , cannot add more data ");
        }
    }
    // Define a method to insert data in an array
    public void insert(int index , int data ){
        try {
            if(index<0 || index>lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index exception ");
            }
            for(int i=lastIndex; i>=index; i--){
                ptr[i+1]=ptr[i];
            }
            lastIndex=lastIndex+1;
            ptr[index]=data;

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }
    // Define a method to edit array element of given index
    public void edit(int index , int newData){
        try{
            if(index<0 || index>lastIndex){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }

            ptr[index]=newData;

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    // Define a method to delete an element from the array at given index
    public void delete(int index){
        try{
            if(index<0 || index>lastIndex){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }
            for(int i=index; i<lastIndex; i++){
                ptr[i]=ptr[i+1];
            }
            lastIndex--;

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    // Define a method to get total number of elements present in the array
    public int count(){
        return lastIndex+1;
    }
    // Define a method to check whether an array is empty or not
    public boolean isEmpty(){
        return lastIndex==-1;
    }
    // Define a method to check whether an array is full or not
    public boolean isFull(){
       return lastIndex+1==ptr.length;
    }
    // Define a method to get value stored at given index
    public int getValue(int index){
        try{
            if(index<0 || index>lastIndex){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception ");
            }
            return  ptr[index];

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    // Define a method to get capacity of the array
    public int getCapacity(){
        return ptr.length;
    }

}