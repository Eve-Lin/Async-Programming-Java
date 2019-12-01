class MyClass implements Runnable{

    public void run(){
        for (int i = 0; i <=10 ; i++) {
            System.out.print(Thread.currentThread().getId());
            System.out.printf("Value %d%n", i);
        }

        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}



public class RunnableInterface {
    public static void main(String[] args) {

        Thread obj1 = new Thread(new MyClass());
        Thread obj2 = new Thread(new MyClass());

        obj1.start();
        obj2.start();

    }
}
