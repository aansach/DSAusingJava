package assignments;

public class Assignment17 {
    public void driver(){
        MyDynArray arr = new MyDynArray(10);
        arr.append(50);
        arr.append(80);
        arr.append(10);
        arr.append(60);
        arr.append(40);
        arr.append(20);
        arr.append(30);
        arr.append(70);
        for(int i=0;i<arr.count();i++){
            System.out.print(" "+arr.getValue(i));
        }
        arr.mergeSort(0, arr.count()-1);
        System.out.println();
        for(int i=0;i<arr.count();i++){
            System.out.print(" "+arr.getValue(i));
        }
        System.out.println();
        int index =arr.binarySearch(60);
        if(index==-1){
            System.out.println("Search Fail");
        }else{
            System.out.println("Data found at index "+index);
        }
    }
}
/*
1. Define an interface 'Searching' with the following methods
    -Linear Search
    -Binary Search

2. Implement interface 'Searching' in Array class.
 */

interface  Searching{
    int linearSearch(int data);
    int binarySearch(int data);
}

/*
Write a Java class with the name DynArray, with instance variables lastIndex to
hold the index of last filled block of Array  and ptr as a reference to an array
 */
class MyDynArray implements Searching,Sorting{
    private int lastIndex;
    private int[] ptr;
    public MyDynArray(){
        lastIndex =-1;
        ptr=new int[1];
    }
    // Define a constructor in DynArray class which takes size of an array
    // as an argument and allocates memory for the array
    public MyDynArray(int size){
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

    public void bubbleSort(){
        int r , i, temp;
        for(r=1 ;r<count();r++){
            for( i=0; i<count()-r; i++){
                if(ptr[i]>ptr[i+1]){
                    temp=ptr[i];
                    ptr[i]=ptr[i+1];
                    ptr[i+1]=temp;
                }
            }
        }
    }

    public void modifiedBubbleSort(){
        int r , i, temp;
        boolean flag =false;
        for(r=1 ; r<count();r++){
            for(i=0 ;i<count()-r;i++){
                if(ptr[i]>ptr[i+1]){
                    flag=true;
                    temp=ptr[i];
                    ptr[i]=ptr[i+1];
                    ptr[i+1]=temp;

                }
            }
            if(flag==false){
                break;
            }
        }
    }

    public int minValueIndex(int j){
        int i , min , minIndex;
        min =ptr[j];
        minIndex=j;
        for( i=j+1; i<count(); i++){
            if(min>ptr[i]){
                min=ptr[i];
                minIndex=i;
            }
        }
        return  minIndex;
    }
    public void selectionSort(){
        int i , temp , minIndex;
        for (i=0; i<count()-1;i++){
            minIndex=minValueIndex(i);
            temp=ptr[i];
            ptr[i]=ptr[minIndex];
            ptr[minIndex]=temp;
        }
    }

    public void insertionSort(){
        int i , j , temp;
        for(i=1 ;i<count(); i++){
            temp=ptr[i];
            for(j=i-1;j>=0;j-- ){
                if(temp<ptr[j]){
                    ptr[j+1]=ptr[j];
                }else{
                    break;
                }
            }
            ptr[j+1]=temp;
        }
    }

    public int partition(int left, int right) {
        int pivot = ptr[left];  // Select the pivot element
        int i = left;
        int j = right;
        int temp;

        while (i < j) {
            // Move i to the right until a number greater than the pivot is found
            do {
                i++;
            } while (i < right && ptr[i] <= pivot);

            // Move j to the left until a number smaller than the pivot is found
            do {
                j--;
            } while (j > left && ptr[j] >= pivot);

            // Swap elements at i and j if i < j
            if (i < j) {
                temp = ptr[i];
                ptr[i] = ptr[j];
                ptr[j] = temp;
            }
        }

        // Place the pivot element in its correct position
        temp = ptr[left];
        ptr[left] = ptr[j];
        ptr[j] = temp;

        return j;  // Return the pivot index
    }
    public void quickSort(int l, int h) {
        if (l < h) {
            int j = partition(l, h);  // Partition the array and get the pivot index
            quickSort(l, j);          // Recursively sort the left subarray
            quickSort(j + 1, h);      // Recursively sort the right subarray
        }
    }

    public void merging(int l ,int m , int u){
        int []L= new int [m-l+1];
        int [] R = new int [u-m];
        int i , j , k;
        for(i=0;i<m-l+1;i++){
            L[i]=ptr[l+i];
        }
        for(j=0;j<u-m;j++){
            R[j]=ptr[m+1+j];
        }
        for(i=0,j=0,k=l ; i<m-l+1&&j<u-m; k++){
            if(L[i]<R[j]){
                ptr[k]=L[i];
                i++;
            }else{
                ptr[k]=R[j];
                j++;
            }
        }
        while(i<m-l+1){
            ptr[k]=L[i];
            i++;
            k++;
        }
        while(j<u-m){
            ptr[k]=R[j];
            j++;
            k++;
        }

    }
    public void mergeSort(int l , int u){
        int m ;
        if(l<u){
            m=(l+u)/2;
            mergeSort(l, m);
            mergeSort(m+1, u);
            merging(l,m,u);
        }
    }

    public void heapSort(){
        Heap heap = new Heap(count());
        for(int i=0;i<count();i++){
            heap.insert(ptr[i]);
        }
        for(int i =count()-1; i>=0;i--){
            ptr[i]= heap.delete();
        }
    }



    public int linearSearch(int data){
        int i ;
        for(i=0; i<count(); i++){
            if(ptr[i]==data){
                return i;
            }
        }
        return -1;

    }

    public int bSearch(int l , int u , int data ){
        int m ;
        if (l <= u) {
            m=(l+u)/2;
            if(ptr[m]==data){
                return m ;
            }
            if(ptr[m]<ptr[m]){
                return bSearch(l, m-1, data);
            }else{
                return bSearch(m+1, count()-1, data);
            }
        }

        return -1;
    }
    @Override
    public int binarySearch(int data) {
        return bSearch(0, count()-1, data);

    }
}