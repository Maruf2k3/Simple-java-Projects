//Importing pakages
import java.util.Scanner;

public class SimpleMultiplicationSum{
    public static void main(String[] args) {
        //initiating scanner object
        Scanner sc = new Scanner(System.in);
        //taking the number which will be multiplied
        int userNum = userVal(sc, "Enter the number: ");
        //taking the upper limit of the multiplication
        int upperBound = userVal(sc, "Enter the limit of multiplication: ");
        //usage of methods
        int sumOfMulti = sumOfMulti(multiple(userNum, upperBound));
        //showing the Numbers after multiplied
        System.out.println("The multiplication is:\n");
        for (int i = 0; i<multiple(userNum, upperBound).length; i++){
            System.out.print(multiple(userNum, upperBound)[i] + " ");
        }
        //finally show the Sum
        System.out.println("\nThe sum of multiples are: " + sumOfMulti);

        
    }
    
    //method to find the multiplication of a single number
    public static int[] multiple(int num , int upperBound){
        //new empty array
        int[] set = new int[upperBound];
        //loop over the array
        for(int i =0; i< set.length; i++){
            // in a certain index add the multiplication 
            set[i] = (i +1) * num;
        }
        return set;//returning the array
    }
    
    //method for the sum of multiples
    public static int sumOfMulti(int[] set){
        //a var to hold the sum
        int sum = 0;
        //looping over the array
        for(int i =0; i< set.length; i++){
            //adding each item in array to the sum value
            sum += set[i];
        }
        return sum;//returning the sum value
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