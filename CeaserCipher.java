//importing scanner
import java.util.Scanner;

public class CeaserCipher{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //User text input
        System.out.print("Write the Text: ");
        String userStr = sc.nextLine();
        //user shift input
        int shift = userVal(sc, "By how charecter you want to shift the crossponding text: ");

        //Magic!!
        System.out.println("The Ciphered text is: ");
        System.out.print(cipher(userStr, shift));
    }

    //method to cipher
    public static StringBuffer cipher(String str , int shift){
        //Made a reader for the string 
        StringBuffer cipher = new StringBuffer();
        //loop over the e=string given
        for(int i=0; i<str.length(); i++ ){
            //cheacking if the charecter is capital
            if (Character.isUpperCase(str.charAt(i))){
                //convertion from assci code to normal letters
                char newChr = (char)(((int)str.charAt(i) + shift - 65) % 26 + 65);
                cipher.append(newChr);
            }
            else{
                //if the charecters are small then
                //convertion from assci code to normal letters
                char newChr = (char)(((int)str.charAt(i) + shift - 97) % 26 + 97);
                cipher.append(newChr);
            }
        }
        return cipher;//return the result
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