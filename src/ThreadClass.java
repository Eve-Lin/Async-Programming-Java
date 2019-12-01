class Demo extends  Thread{

    public void run(){

        for (int i = 0; i <=10 ; i++) {
            System.out.print(Thread.currentThread().getId());
            System.out.printf("Value %d%n", i);
        }

        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

public class ThreadClass{

    public static void main(String[] args) {

        Demo obj1 = new Demo();
        obj1.start();

        Demo obj2 = new Demo();
        obj2.start();
    }
}