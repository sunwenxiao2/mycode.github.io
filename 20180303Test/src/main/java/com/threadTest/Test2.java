package main.java.com.threadTest;

/**
 * Created by sunwenxiao on 2018/5/8.
 */
public class Test2 {
    public  void syncMethod(){
        synchronized (Test2.class){
            for (int i = 0 ;i<1000;i++){
                System.out.println(Thread.currentThread().getName()+"=="+i );
            }
        }
    }


    public static void main(String[] args) {
        final Test2 test2 = new Test2();
        final Test2 test3 = new Test2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test2.syncMethod();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test3.syncMethod();
            }
        });
        thread1.start();
        thread2.start();



    }
}
