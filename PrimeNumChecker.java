import java.util.Scanner;
public class PrimeNumChecker{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            int primeNum = userVal(sc, "Please input the number or Quit[0]: ");
            if(primeNum == 0){
                System.out.println("Thank you for using primeChecker");
                System.out.println("Note: \n0 is not a prime number");
                break;
            }
        
            if(primeNum == 1){
                System.out.println(primeNum + " not a prime number");
                break;
            }
            
            boolean check = primeCheker(primeNum);
            if(!check){
                System.out.println(primeNum + " is a prime number");
            }
            else{
                System.out.println(primeNum + " is not a prime number");
            }       
        } 
    }

    public static boolean primeCheker(int num){

        boolean flag = false;
        for(int i = 2; i <= num/2; ++i){
            if(num % i == 0){
                flag = true;
                break;
            }
        }
        return flag;
        
    }

    //user validation so that we get only integer
    public static int userVal(Scanner sc , String promt){

        int userInput = -1;//var to neglect any -ve number

        while (userInput <0){
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