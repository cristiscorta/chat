package threads;

public class Test {
    public static void main(String[] args) {
       new Test().run();

    }
    public void run(){
        Thread first = new Thread(new Job());
        Thread second = new Thread(new Job());
        Thread third = new Thread(new Job());
        first.start();
        second.start();
        third.start();
    }
    class Job implements Runnable{
        @Override
        public void run() {
            while(true){
            System.out.println(Thread.currentThread().getName());
        }}
    }
}
