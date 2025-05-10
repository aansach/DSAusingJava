package assignments;

public class Assignment11 {
    public void driver(){
        f1(10);
        System.out.println();
        reversef1(10);
        System.out.println();
        evenf1(10);
        System.out.println();
        reverseEvenf1(10);
        System.out.println();
        oddf1(10);
        System.out.println();
        reverseOddf1(10);
    }
    // Write a recursive function to print first n natural numbers
    public void f1(int n ){
        if(n>0){
            f1(n-1);
            System.out.print(" "+n);
        }
    }
    // write a recursive function to print first N natural numbers in reverse order
    public void reversef1(int n){
        if(n>0){
            System.out.print(" "+n);
            reversef1(n-1);
        }
    }
    // write a recursive function to print first N even natural numbers
    public void evenf1(int n ){
        if(n>0){
            evenf1(n-1);
            System.out.print(" "+2*n);
        }
    }
    //write a recursive function to print first N even natural numbers in reverse order
    public void reverseEvenf1(int n ){
        if(n>0){
            System.out.print(" "+2*n);
            reverseEvenf1(n-1);
        }
    }
    //write a reversive function to print first N odd natural number
    public void oddf1(int n){
        if(n>0) {
            oddf1(n - 1);
            System.out.print(" " + (2 * n - 1));
        }
    }
    // Write a recursive function to print first N natural numbers in reverse Oder
    public void reverseOddf1(int n){
        if(n>0) {
            System.out.print(" " + (2 * n - 1));
            reverseOddf1(n - 1);
        }
    }
}
