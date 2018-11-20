package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableDemo {
    private Lock lock = new ReentrantLock();

    //需要参与同步的方法
    private void method(Thread thread){
        lock.lock();
        try {
            System.out.println("线程名"+thread.getName() + "获得了锁");
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("线程名"+thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final RunnableDemo runnableDemo = new RunnableDemo();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                runnableDemo.method(Thread.currentThread());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                runnableDemo.method(Thread.currentThread());
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
