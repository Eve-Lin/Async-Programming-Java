import java.io.IOException;

public class ThreadDemo {
     public static void main(String[] args) throws IOException {

         int n = 1000;
         Thread thread = new Thread(()-> getNumbersInRange(0, n));
         thread.setDaemon(true);
         thread.start();
         System.out.println("Main thread is done!");

//         try{
//             thread.join();
//         }catch(InterruptedException e){
//             e.printStackTrace();
//         }



      }

    private static void getNumbersInRange(int i, int n) {

        for (int j = i; j < n; j++) {

            System.out.println(j);

        }
        System.out.println("Started thread is done");
    }
}
