public class MyThread extends Thread {


    public MyThread(ThreadGroup group, String s) {
        super(group, s);
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(3000);
                System.out.printf("Я %s. Всем привет!\n", getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
