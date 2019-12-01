import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentClasses {


    static Queue<Integer> queue = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) throws IOException{

        List<Thread> threadList = new ArrayList<>();
        int coreCount = 4;
        for (int i = 0; i < coreCount ; i++) {

            Thread thread = new Thread(() ->{
                for (int j = 0; j < 100; j++) {
                    queue.add(j);
                }
            });
            thread.start();
            threadList.add(thread);

        }

        for (Thread thread: threadList) {

            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println(queue.size());
    }
}
