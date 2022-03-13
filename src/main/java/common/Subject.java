package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subject {

    private List<Observer> asyncObservers;
    private List<Observer> joinObservers;

    protected Subject() {
        this.asyncObservers = new LinkedList<>();
        this.joinObservers = new LinkedList<>();
    }

    public Subject async(Observer observer) {
        this.asyncObservers.add(observer);
        return this;
    }

    public Subject join(Observer observer) {
        this.joinObservers.add(observer);
        return this;
    }

    protected void runNotify() throws InterruptedException {
        int i = 0;
        List<Thread> threads = new ArrayList<>(asyncObservers.size());
        for(Observer observer : asyncObservers) {
            Thread thread = new Thread(observer, "[tread-" + i++ + "]");
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads) {
            thread.join();
        }
        System.out.println("Terminou as duas!");
        for(Observer observer: joinObservers) {
            Thread thread = new Thread(observer, "[tread-" + i++ + "]");
            thread.start();
        }
    }

}
