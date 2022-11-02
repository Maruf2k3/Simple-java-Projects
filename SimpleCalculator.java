/*
 * Author: Maruf Rahman
 * Date: 01/11/2022
 * 30 Days Java small project Challange
 * Day 1
 * Simple Calculator
 * Features:
 * addition , subtraction , multiplication, divition, power of 2 numbers
 */
import java.util.Scanner;
public class SimpleCalculator{
    public static void main(String[] args) throws Exception {
        //Introduction 
        System.out.println("Welcome To Simple Calculator!");
        System.out.println("Choose what operation you wish to do:"); 
        //object for taking user Input 
        Scanner sc = new Scanner(System.in);

        //Loop until the user Exits
        while(true){
            
            System.out.println("---------------------------------------------------------------------------------------------------");
            //for operator
            int userChoice = userVal(sc, "\n[1]Add\n[2]Subtract\n[3]Multiply\n[4]Divide\n[5]power\n[0]ToExit: " );
            if (userChoice == 0){System.out.println("Thank you for using Simple Calculator!"); break;}

            //for Num X
            int numX = userVal(sc, "Frist number: ");
            //for Num Y
            int numY = userVal(sc, "Second Number: ");
            //Doing all the calculation
            calculation(userChoice, numX, numY);
            
        }
    } 

    //function where calculate upon the operator
    public static void calculation(int user , int num1 , int num2){
        //made an array for the user operator signal
        int[] operationArr = {1,2,3,4,5,6};
        //all the solution is saved here
        int sol = 0;
        if(user ==operationArr[0]){sol = add(num1 , num2);
            System.out.println(num1 + " + " + num2 + " = " + sol);}

        else if(user == operationArr[1]){
            sol = sub(num1, num2); 
            System.out.println(num1 + " - " + num2 + " = " + sol);}

        else if(user == operationArr[2]){sol =  multi(num1, num2); 
            System.out.println(num1 + " x " + num2 + " = " + sol);}

        else if(user == operationArr[3]){sol =  divide(num1, num2);
            System.out.println(num1 + " / " + num2 + " = " + sol);}

        else if(user == operationArr[4]){sol =  pwr(num1, num2);
            System.out.println(num1 + " ^ " + num2 + " = " + sol);}
        
    
    }

    //funtions for every operation
    public static int add(int num1 , int num2) {
        return num1 + num2;
    }
    public static int sub(int num1 , int num2){
        return num1 - num2;
    }
    public static int multi(int num1, int num2){
        return num1 * num2;
    }
    public static int divide(int num1 , int num2){
        if (num1 == 0 || num2 == 0){
            System.out.println("Number can't be devided by zero");
        }
        return num1/num2;
    }
    public static int pwr(int num1 , int num2){
        return (int) Math.pow(num1, num2);
    }
    public static int abs(int num1){
        return Math.abs(num1);
    }

    //user validation so that we get only integer
    public static int userVal(Scanner sc , String promt){

        int userInput = -1;//var to neglect any -ve number

        while (userInput<0){
            System.out.print(promt);

            String userString = sc.nextLine();//takig a string from user

            try{

                userInput = Integer.valueOf(userString);//try to convert it to int
            }
            catch(NumberFormatException nFE){//if can't be converted to string then throw this error
                System.out.println(userString+ " is not a vlid input!");
                userInput = -1;//restarts the while loop
            }
        }
        return userInput;//finally returns the new value
    }
}