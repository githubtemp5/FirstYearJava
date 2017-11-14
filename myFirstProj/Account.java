
//UP826133
public class Account
{
    // instance variables - replace the example below with your own
    private int balance;
    private String owner;

    public Account(String name){
        owner = name;
        
        balance = 0;
    }

    public void deposit(int anAmount){
    balance += anAmount;
    }
    public void withdraw(int anAmount){
        int amountWithdrawn;
    
    if(anAmount<= balance){
        amountWithdrawn = anAmount;  
    }
    
    else{
        amountWithdrawn = balance;
    }
    
        balance -=amountWithdrawn;
    }
    public void print(){
        System.out.println("Owner = "+owner + "    Balance =" + balance);
    }
}
