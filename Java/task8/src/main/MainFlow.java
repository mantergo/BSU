package main;


import java.util.ArrayList;

public class MainFlow extends Thread {

    private int n = 15;
   ArrayList<StringBuffer> OutData = new ArrayList<>();


    @Override
    public void run() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++)
                    if (!isInterrupted()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            break;
                        }
                       System.out.println("a"+i);
                        OutData.add(new StringBuffer("a"+i));

                    }
            }
        };

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    if (!isInterrupted()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            break;
                        }
                        System.out.println("b" + i);
                        OutData.add(new StringBuffer("b"+i));

                    }
                }

            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++)
                    if (!isInterrupted()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            break;
                        }
                        System.out.println("c" + i);
                        OutData.add(new StringBuffer("c"+i));

                    }
            }
        });


        thread1.setPriority(MAX_PRIORITY);
        thread2.setPriority(MIN_PRIORITY);
        thread3.setPriority(MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();

        while (!isInterrupted()) {
            if (OutData.size() > 15) {
                thread2.interrupt();
                System.out.println("interrupted");
                break;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MainFlow flow = new MainFlow();
        flow.run();


    }
}
