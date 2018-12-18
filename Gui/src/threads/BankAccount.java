package threads;

public class BankAccount {
    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }
    public synchronized void withdraw(int amount){
        if(balance >= amount){
            try {
                    Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("Balance: " + balance);
        }
    }
}
