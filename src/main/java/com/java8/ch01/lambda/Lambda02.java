package com.java8.ch01.lambda;

public class Lambda02 {

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        }
    };

    static Runnable runnableLambda = ()-> {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    };
    public static void main(String[] args) throws InterruptedException {

        runThread(runnable);

        runThread(runnableLambda);
    }

    private static void runThread(Runnable runnable) throws InterruptedException {
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
    }
}
