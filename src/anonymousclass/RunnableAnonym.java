package anonymousclass;

public class RunnableAnonym {
}
class Create {

    public static Runnable createRunnable(String text, int repeats) {
        return new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < repeats) {
                    System.out.println(text);
                    i ++;
                }
            }
        };// an instance here
    }
}