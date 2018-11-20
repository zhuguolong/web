package Thread;

public class Thread_demo2 {
    public int inc = 0;

    public synchronized void incerase() {
        inc++;
    }

    public static void main(String[] args) {
        final Thread_demo2 threadDemo2 = new Thread_demo2();
        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000000; j++) {
                        threadDemo2.incerase();
                    }
                }
            }.start();
        }

        /** 保证前面的线程都执行完 */
        while (Thread.activeCount() > 2) {
            System.out.println("活跃线程数：" + Thread.activeCount());
            Thread.yield();
        }

        System.out.println("inc值：" + threadDemo2.inc);
    }
}
