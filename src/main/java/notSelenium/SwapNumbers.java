package notSelenium;

public class SwapNumbers {
    public static void main (String []args){

        int number1 = 10;
        int number2 = 20;
        swapNumber(number1, number2);
        swapNumberTwo(number1, number2);

    }

    public static void swapNumber(int num1, int num2){
        int temp = num1;
        num1  = num2;
        num2 = temp;

        System.out.println("value of num 1: "+ num1);
        System.out.println("Value of num 2: "+ num2);
    }


    public static void swapNumberTwo(int num1, int num2){
        num1  = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        System.out.println("value of num 1: "+ num1);
        System.out.print("Value of num 2: "+ num2);
    }
}
