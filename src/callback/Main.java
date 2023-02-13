package callback;

import java.util.Scanner;

public class Main {

    private static String message;
    private static int errorCode;

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        message = scanner.nextLine();
        errorCode = Integer.parseInt(scanner.nextLine());

        startLongProcess(new Callback1() {
            @Override
            public void onStarted() {
                System.out.println("The process started");
            }

            @Override
            public void onStopped(String cause) {
                System.out.println(cause);
            }

            @Override
            public void onFinished(int code) {
                if (code == 0) {
                    System.out.println("The process successfully finished");
                } else {
                    System.out.printf("The process is finished with error: %d", code);
                }
            }
        });

    }

    public static void startLongProcess(Callback1 callback) {
        callback.onStarted();
        callback.onStopped(message);
        callback.onStarted();
        callback.onFinished(errorCode);
    }

}

interface Callback1 {

    void onStarted();

    void onStopped(String cause);

    void onFinished(int code);
}
/**
 * another exercise
 */
class IteratorExecutor {

    static void performIterationsWithCallback(int numberOfIterations, LoopCallback callback) {
        for (int i = 0; i < numberOfIterations; i++) {
            callback.onNewIteration(i);
        }
    }

    static void startIterations(int numberOfIterations) {
        LoopCallback callback = new LoopCallback() {
            @Override
            public void onNewIteration(int iteration) {
                System.out.printf("Iteration: %d%n", iteration);
            }
        };
        performIterationsWithCallback(numberOfIterations, callback);
        // invoke the method performIterationsWithCallback here
    }
}

// Don't change the code below
interface LoopCallback {

    void onNewIteration(int iteration);
}
/**
 * another exercise
 */
class CreateInstance {

    public static SuperClass create() {

        SuperClass instance = new SuperClass() {
            @Override
            public void method2() {
                System.out.println("method2");
            }
            @Override
            public void method3() {
                System.out.println("method3");
            }

        };/* create an instance of an anonymous class here,
                                 do not forget ; on the end */

        // call the overridden methods
        instance.method2();
        instance.method3();
        return instance;
    }
}

// Don't change the code below

abstract class SuperClass {

    public static void method1() {
        System.out.println("It's a static method.");
    }

    public void method2() {
        System.out.println("It's not a static method.");
    }

    public abstract void method3();
}
