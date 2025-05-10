package assignments;


public class Assignment13 {
    public void driver(){
        System.out.println("sum of fibonacci "+fibN(10));
        System.out.print("The binary of the given number is : ");
        printDtoB(10);
        System.out.println();
        System.out.print("The Octal of the given number is : ");
        printDtoO(23);
        System.out.println();
        System.out.println("The reverse of the given number is : ");
        reverse(1234);
        System.out.println();
        System.out.println("The sum of the square of the first N natural numbers : "+squareSumN(5));


    }
    // write a recursive function to find Nth term of Fibonacci series
    public int fibN(int n ){
        if(n==0||n==1 ){
            return n;
        }
        return fibN(n-1)+fibN(n-2);
    }
    // write a recursive function to print binary of a given decimal number
    public void printDtoB(int n){
        if(n>0) {
            printDtoB(n / 2);
            System.out.print(" "+n % 2);
        }
    }
    // write a recursive function to print octal of a given decimal number
    public void printDtoO(int n){
        if(n>0){
            printDtoO(n/8);
            System.out.print(" "+n%8);
        }
    }
    // write a recursive function to reverse a number
    public void reverse(int n){
        if(n>0){
        System.out.print(" "+n%10);
        reverse(n/10);
        }

    }
    // write a recursive function to calculate sum of squares of first N natural numbers
    public int squareSumN(int n){
        if(n>0){
            return squareSumN(n-1)+n*n;
        }
        return 0;
    }
}
