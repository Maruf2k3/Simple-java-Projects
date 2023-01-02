public class Managment{
    private static int totalAmount;


    public void deposit(int amount){
        totalAmount += amount;
    }

    public void withDraw(int amount){
        if(totalAmount == 0){
            System.out.println("There is not enough balance avilable");
        }
        else{
            totalAmount -= amount;
        }
    }

    public void checkBalance(){
        System.out.println("Current balance is: "+totalAmount);
    }
}
