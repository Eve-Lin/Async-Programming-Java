public class RaceCondition {

    static double a = 10;
    static double b;


    public static void main(String[] args) {
        Runnable r1 = () ->
        {
            if (a == 10) {
                try {
                    Thread.sleep(0);
                    b = a / 2;
                    System.out.println(Thread.currentThread().getName() + ": " + b);
                } catch (InterruptedException e) {
                }
            }

        };
        Runnable r2 = () -> {
            a = 12;
        };

        Thread thd1 = new Thread(r1, "Thread 1");
        Thread thd2 = new Thread(r2, "Thread 2");
        thd1.start();
        thd2.start();
    }
}
