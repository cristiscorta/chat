package threads;

public class BankTest {
    public static void main(String[] args) {
        new BankTest().run();
    }

    public void run(){
        BankAccount account = new BankAccount(1000);
        Thread ryan = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<10; i++) {
                    account.withdraw(50);
                }
            }
        });
        ryan.setName("Ryan");

        Thread marry = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<10; i++) {
                    account.withdraw(100);
                }
            }
        });
        marry.setName("Marry");
        ryan.start();
        marry.start();
    }

}
