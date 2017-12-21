package com.xproject.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;


public class TestThread implements Runnable{

    AtomicReference<String> result = new AtomicReference<>();

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    String question;

    public List<String> getEngines() {
        return engines;
    }

    public void setEngines(List<String> engines) {
        this.engines = engines;
    }

    List<String> engines;
    @Override
    public void run() {
        for(String base: engines) {

            String url = base + question;
            result.compareAndSet(null, url);
        }

        while(result.get() == null);
        System.out.println(Thread.currentThread().getName() + result.get().toString());
    }
}

class MyThread {
    public static void main(String[] args) {
        TestThread testThread1 = new TestThread();
        TestThread testThread2 = new TestThread();
        List<String> engines1 = new ArrayList<String>();
        List<String> engines2 = new ArrayList<String>();
        testThread1.setQuestion("Q1");
        engines1.add("why1");
        engines1.add("why2");
        testThread1.setEngines(engines1);
        testThread2.setQuestion("Q2");
        engines2.add("why3");
        engines2.add("why4");
        testThread2.setEngines(engines2);
        Thread thread1 = new Thread(testThread1);
        Thread thread2 = new Thread(testThread2);

        thread1.start();
        thread2.start();



        }
}