import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //new object 
        ToDoList toDoList = new ToDoList();

        while(true){
            //manager form
            System.out.println("\nWelcome To simple TODO list.");
            System.out.println("TODO list manager: ");
            System.out.println("Press[1] to add an item");
            System.out.println("Press[2] to remove an item");
            System.out.println("Press[3] to display the TODO list");
            System.out.println("Press[0] to quit TODO list manager");
            System.out.println("-------------------------------------------\n");
            int userOption = userVal(sc, "Enter your input: ");
            System.out.println("-------------------------------------------");

            //quit function
            if(userOption == 0){
                System.out.println("Thank you for using TODO list manager!");
                sc.close();
                break;
            }
            //continew function
            else{
                userOptionProcess(userOption, sc);
            }
        }
    }

    public static void userOptionProcess(int selection , Scanner sc){
        //add
        if(selection == 1){
            System.out.print("Enter the task: ");
            String newTask = sc.nextLine();
            ToDoList.addTask(newTask);
        }
        //remove
        else if(selection == 2){
            int newTask = userVal(sc, "Enter the task number: ");
            ToDoList.removeTask(newTask - 1);
        }
        //display
        else if(selection == 3){
            ToDoList.displayTask();
        }
        //error catching
        else{
            System.out.println("Invalid Input!");
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
