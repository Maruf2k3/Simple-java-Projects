import java.util.Scanner;
import java.util.Map.Entry;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Managment customer = new Managment();
        //userName is the key and the password is the value
        HashMap<String, Integer> account = new HashMap<>();


        while(true){
            
            System.out.println("\nWelcome to Gibrish Bank!");
            System.out.println("This is bank Manager!");
            System.out.println("Press [1] to Create account");
            System.out.println("Press [2] to diposit money");
            System.out.println("Press [3] to withdraw money");
            System.out.println("Press [4] to check the current balance");
            System.out.println("Press [5] to check the created accounts");
            System.out.println("Press [0] to quit Gibrish Bank");
            System.out.println("-----------------------------------------------\n");
            int userOption = userVal(sc, "Whats your query: ");
            System.out.println("-----------------------------------------------");


            if(userOption == 0){
                sc.close();
                break;
            }
            else{
                userOptionProcess(userOption, sc, customer, account);
            }

        }
    }

    public static void userOptionProcess(int selection , Scanner sc , Managment customer , HashMap<String , Integer> account){
        //creat
        if(selection == 1){
            creatAcoount(sc , account , selection);   
        }
        //deposit
        if(selection == 2){
            int newAmount = userVal(sc, "Enter the amount: ");
            customer.deposit(newAmount);
            
        }
        //remove
        else if(selection == 3){
            int withDrawAmount = userVal(sc, "Enter the amount number: ");
            customer.withDraw(withDrawAmount);
        }
        //display
        else if(selection == 4){
            customer.checkBalance();
        }
        else if(selection == 5){
            creatAcoount(sc , account , selection); 
        }
    }

    public static void creatAcoount(Scanner sc , HashMap<String , Integer> account , int selection){

        if(selection == 5){
            System.out.println(account);
            //account.clear();
        }
        else{
            System.out.print("Please write the userName: ");
            String userName = sc.nextLine();
            while(true){
                if(account.containsKey(userName)){
                    System.out.println("This user is already registred");
                    creatAcoount(sc, account, selection);
                }
                else{
                    int passWord = userVal(sc, "What is the password: ");
                    account.put(userName, passWord);
                    for(Entry<String, Integer> tempMap: account.entrySet()){
                        if(tempMap.getKey().equals(userName)){
                            System.out.println(tempMap.getKey() + " your account has been offcially created");
                        }
                    }
                    break;
                }
            }
        }
        
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
