package Thread;

public class Thread_demo3 {
    public static void main(String[] args) {
        new Thread(new AddThread(), "AddThread").start();
        System.out.println("asdfasd");
        System.out.println("52345");
        System.out.println("asdffgjfasd");
    }
}

class AddThread implements Runnable {
    int num = 0;
    public void run() {
        for (int i = 0; i < 10000; i++) {
            num += i;
        }
        System.out.println("num = " + num);
    }
}
