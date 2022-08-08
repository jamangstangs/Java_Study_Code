package java8.lambda;

public class LambdaMain {

    public static void main(String[] args) {

        Runnable r1 = () -> System.out.println("Hello world1");

        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Hello world 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello world 3"));
    }
    public static void process(Runnable r) {
        r.run();
    }
}
제