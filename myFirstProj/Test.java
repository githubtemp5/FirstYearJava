public class Test {
    public void useAccount() {
    Account account_1;
    account_1 = new Account("Fred");
    
    Account account_2;
    account_2 = new Account("Jane");
    
    account_1.print();
    account_1.deposit(200);
    account_1.print();
    account_1.withdraw(125);
    account_1.print();
    
    account_1.print();
    account_1.deposit(100);
    account_1.print();
    account_1.withdraw(50);
    account_1.print();
    }
}