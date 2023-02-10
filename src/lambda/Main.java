package lambda;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

class Operator {
    public static IntBinaryOperator binaryOperator = (x, y) -> {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    };
}
public class Main {
}
