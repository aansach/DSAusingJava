package assignments;

public class Assignment12 {

    public void driver(){
        System.out.println("The sum of first N natural number is "+f1(10));
        System.out.println("The sum of first N even natural number is "+evenf1(5));
        System.out.println("The sum of first N odd natural number is "+oddf1(5));
        System.out.println("The factorial of the given number is "+fact(5));
        System.out.println("The sum of the digits of a given number "+calcuateSum(219));

    }
    // Write a recursive function to calculate sum of first N natural number
    public int f1(int n ){
        if(n>0){
            return f1(n-1)+n;
        }
        return  0;
    }
    // write a recursive function to calculate sum of first N even natural numbers
    public int evenf1(int n){
        if(n>0){
            return evenf1(n-1)+2*n;
        }
        return  0;
    }
    // write a recursive function to calculate sum of first N odd natural numbers
    public int oddf1(int n ){
        if(n>0){
            return oddf1(n-1)+(2*n-1);
        }
        return 0;
    }
    // write a recursive function to calculate factorial of a number
    public int fact(int n ){
        if(n>0){
            return fact(n-1)*n;
        }
        return 1;
    }
    // write a recursive function to calculate sum of the digits of the digits of a given number
    public int calcuateSum(int n ){
        if(n>0){
            return calcuateSum(n/10)+(n%10);
        }
        return 0;
    }
}
