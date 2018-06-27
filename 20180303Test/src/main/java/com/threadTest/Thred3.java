package main.java.com.threadTest;

/**
 * Created by sunwenxiao on 2018/5/6.
 */
public class Thred3 extends  Thread{
    volatile boolean stop = false;

    public static void main(String args[]) throws Exception {


        Thred3 thread = new Thred3();

        System.out.println("Starting thread...");
        thread.start();

        Thread.sleep(3000);

        System.out.println("Asking thread to stop...");

    /*
    * 如果线程阻塞，将不会检查此变量,调用interrupt之后，线程就可以尽早的终结被阻
    * 塞状 态，能够检查这一变量。
    * */
        thread.stop = true;

    /*
    * 这一方法实际上完成的是，在线程受到阻塞时抛出一个中断信号，这样线程就得以退
    * 出阻 塞的状态
    * */
        thread.interrupt();

        Thread.sleep(3000);
        System.out.println("Stopping application...");
        System.exit(0);
    }

    public void run() {
        while (!stop) {
            System.out.println("Thread running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // 接收到一个中断异常（InterruptedException），从而提早地终结被阻塞状态
                System.out.println("Thread interrupted...");
            }
        }

        System.out.println("Thread exiting under request...");
    }
}
