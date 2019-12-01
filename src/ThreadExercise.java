import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadExercise {

    static List<Integer> numbers;
   static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        numbers = new ArrayList<>();
        for (int i = 0; i < 9999; i++) {

            numbers.add(i);

        }

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            Thread thread = new Thread(() -> removeAllElements(), "Thread" + i);
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(numbers.size());

    }

    public static void removeAllElements() {

        while (numbers.size() > 0) {
//            synchronized (numbers) {
            lock.lock();
                if (numbers.size() > 0) {
                    numbers.remove(numbers.size() - 1);
                }

//            }
            lock.unlock();
        }
    }
}
