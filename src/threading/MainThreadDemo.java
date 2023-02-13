package threading;

import java.util.Scanner;

public class MainThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // main thread

        System.out.println("Name: " + t.getName());
        System.out.println("ID: " + t.getId());
        System.out.println("Alive: " + t.isAlive());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("Daemon: " + t.isDaemon());
        System.out.println();
        t.setName("my-thread");
        System.out.println("New name: " + t.getName());
    }
}
/**
 * exercise
 */
class ThreadUtil {
    public static String getName(Thread thread) {
        return thread.getName();
    }
}
/**
 * exercise
 */
class ThreadUtil1 {
    public static void printIfDaemon(Thread thread) {
        if (thread.isDaemon()) {
            System.out.println("daemon");
        } else {
            System.out.println("not daemon");
        }
    }
}
/**
 * exercise
 */
class MessageNotifier extends Thread {
    private final int repeats;
    // write fields to store variables here

    public MessageNotifier(String msg, int repeats) {
        super(msg);
        this.repeats = repeats;
    }

    @Override
    public void run() {
        for (int i = 0; i < repeats; i++) {
            System.out.println(getName());
        }
    }
}
class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int repeats = scanner.nextInt();
        Thread thread = new MessageNotifier(string, repeats);
        thread.start();
    }
}
/**
 * exercise
 */
class NumbersThread extends Thread {
    private int from;
    private int to;
    public NumbersThread(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = from; i <= to ; i++) {
            System.out.println(i);
        }
    }
}
class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        Thread thread2 = new NumbersThread(from, to);
        thread2.start();
    }
}
/**
 * exercise with Runnable
 */
class Starter {

    public static void startRunnables(Runnable[] runnables) {
        for (Runnable runnable : runnables
             ) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}