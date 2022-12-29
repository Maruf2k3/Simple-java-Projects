import java.util.Scanner;
public class TempConvertor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            //user Input
            System.out.println("Press the number beside the respective convertion.");
            int choice = userVal(sc, "Choose either[Celsius[1] or Fahrenheit[2]] Quit[0]: ");
            if(choice >= 3){print();}
            else if(choice ==0){break;}
            else{
                int value = userVal(sc, "What is the value: ");
                //logic calling
                convertion(value,choice);
            }
        }
    }
    
    public static void convertion(int value , int choice){
        //0°C × 9/5) + 32
        //0°C + 273.15
        //(32°F − 32) × 5/9
        double fahrenheit =(value * 9/5) + 32;
        double kelvin = (value + 273.15);
        double celcius = (value - 32) * 5/9; 
        //if celcius
        if(choice == 1){
            System.out.println("The result in Fahrenheit is: " + fahrenheit +"*F");
            System.out.println("The result in Kelvin is: " + kelvin +"*K\n");
        }
        //if farenhite
        else if(choice == 2){
            System.out.println("The result in Celcius is: " + celcius +"*C");
            System.out.println("The result in Kelvin is: " + kelvin +"*K\n");
        }
    }

    public static String print(){
        return "Please choose a correct type of convertion";
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