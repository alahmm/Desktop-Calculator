package functioninterface;

import java.util.Scanner;

class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT = (i1, i2, i3) -> i1 != i2 && i2 != i3 && i1 != i3;// Write a lambda expression here

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        System.out.println(ALL_DIFFERENT.test(num1, num2, num3));
    }
    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test (int arg1, int arg2, int arg3);
    }
}
