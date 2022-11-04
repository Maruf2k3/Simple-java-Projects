/*
 * Number gussing is a fun way to test your luck aganist the computer
 * Computer generates a randon number and you get certain amount of life to guess the right number!
 * Its simple and fun to code
 * Have Fun!
 */

//Imported lib
import java.util.Scanner;
import java.util.Random;

public class NumberGussing{
    //variables to hold various task
    private static final int MAXTURNS = 3;
    private static int currentTurn = 0;
    private static boolean winStatus = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//new object for scanner
        Random rn = new Random();//new object for random
        //start of the game
        System.out.println("Welcome to Number Gussing Game!");
        System.out.println("You have only 3 lives");
        
        //run the game
        while (currentTurn < MAXTURNS){
            //user Input
            int userInpt = userVal(sc, "Enter a number from {1 - 10} or press {0}Exit");
            if(userInpt == 0){
                System.out.println("Thank you for playing!");
                break;
            }
            //computers Input
            int compInpt = rn.nextInt(10) + 1;
            //main game logic
            game(userInpt, compInpt);
            //Status update
            if(winStatus){break;}
            //End game
            if(currentTurn == MAXTURNS){
                System.out.println("Out of life time!");
            }
        }
        
        
    }
    //Logic of game
    public static void game(int user , int comp){
        
        if (user == comp){
            System.out.println("You won!");
            winStatus = true;
        }
        else if(user < comp){
            System.out.println("Computer gussed higher!");
            currentTurn++;
        }
        else if(user > comp){
            System.out.println("Computer gused lower!");
            currentTurn++;
        }
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