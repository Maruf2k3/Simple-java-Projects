import java.util.ArrayList;
public class ToDoList{

    private static ArrayList<String> tasks;
    public ToDoList(){
        tasks = new ArrayList<>();
    }

    public static void addTask(String task){
        tasks.add(task);
    }

    public static void removeTask(int indx){
        if(indx == 0){
            System.out.println("Invalid task number");
        }
        try {
                tasks.remove(indx);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task number");
        }
        
        
    }

    public static void displayTask(){
        if(tasks.size() == 0){
            System.out.println("There are no tasks available at this momment");
        }
        else{
            for(int i = 0; i < tasks.size(); i++){    
                System.out.println(i + 1 + "."+  tasks.get(i) + "\n");
                
            }
        }
        
    }
}