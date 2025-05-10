package assignments;

public class Assignment15 {
    public void driver() {

    }
}

/*
 * Define a class Heap with member variable lastIndex and reference variable ptr
 */
class Heap {
    private int lastindex;
    private int[] ptr;

    // Define a paramaterized constructor to create a heap of given size
    public Heap(int size) {
        ptr = new int[size];
        lastindex = -1;
    }

    public boolean isFull() {
        return lastindex + 1 == ptr.length;
    }

    public boolean isEmpty() {
        return lastindex == -1;
    }

    // Define a function to insert data in the heap
    public void insert(int data) {
        if (isFull()) {
            int[] temp;
            temp = new int[ptr.length * 2];
            for (int i = 0; i < ptr.length; i++) {
                temp[i] = ptr[i];
            }
            ptr = temp;
        }
        int index, parentIndex;
        for (index = lastindex + 1; index > 0; index = parentIndex) {
            parentIndex = (index - 1) / 2;
            if (ptr[parentIndex] < data) {
                ptr[index] = ptr[parentIndex];
            } else {
                break;
            }
        }
        ptr[index] = data;
        lastindex++;
    }

    // Define a function to get the top element in the heap
    public int top() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is Empty");
        }
        return ptr[0];
    }

    // Define a function to delete a data form the heap
    public int delete() {
        int item, temp, index, leftIndex, rightIndex;
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is Empty");
        } else {
            item = ptr[0];
            temp = ptr[lastindex];
            lastindex--;
            index = 0;
            leftIndex = 1;
            rightIndex = 2;
            while (leftIndex < lastindex) {
                if (ptr[leftIndex] > ptr[rightIndex]) {
                    if (temp < ptr[leftIndex]) {
                        ptr[index] = ptr[leftIndex];
                        index = leftIndex;
                    }else {
                        break;
                    }
                }else{
                    if(temp<ptr[rightIndex]){
                        ptr[index]=ptr[rightIndex];
                        index=rightIndex;
                    }else {
                        break;
                    }
                }
                leftIndex=2*index+1;
                rightIndex=2*index+2;
            }
            if(leftIndex==lastindex && temp<ptr[leftIndex]){
                ptr[index]=ptr[leftIndex];
                index=leftIndex;

            }
            ptr[index]=temp;
            return item;
        }

    }

}