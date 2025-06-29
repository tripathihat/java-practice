import java.util.function.Function;
import java.util.function.Predicate;

public class lambdaexp {

  public static void main(String[] args) {
    System.out.println("Hello Stream");
    SumOperation so = new SumOperation();
    int sum = so.operate(45, 60);
    System.out.println(sum);

    // by lambda
    MathOperation sumMathOperation = (a, b) -> a + b;
    MathOperation subMathOperation = (a, b) -> a - b;

    int sumLambda = sumMathOperation.operate(5, 15);
    int subLambda = subMathOperation.operate(80, 45);
    System.out.println(sumLambda);
    System.out.println(subLambda);

    // Predicate (functional interface) test function whose return type is boolean
    // and parameter is generic type
    // odd-even program
    Predicate<Integer> isEvenPredicate = a -> a % 2 == 0;
    System.out.println(isEvenPredicate.test(67));

    // is word starting with A
    Predicate<String> isWordStartWithA = a -> a.startsWith("A");
    System.out.println(isWordStartWithA.test("Rosh"));

    Predicate<String> isWordEndWithA = a -> a.toLowerCase().endsWith("t");

    Predicate<String> and = isWordEndWithA.and(isWordEndWithA);
    System.out.println(and.test("rosh"));

    // Function (functional interface) method name

    Function<Integer, Integer> squareFunction = a -> a * a;
    System.out.println("square:" + squareFunction.apply(6));

    Function<Integer, String> isEvenOrOdd = a -> {
      if ((a * a * a) % 2 == 0)
        return "Even";
      else
        return "Odd";
    };

    System.out.println("isEvenOrOdd:" + isEvenOrOdd.apply(6));

    Function<Integer, Integer> quad = a -> a * a * a * a;
    System.out.println("quad:" + quad.apply(5));

  }

}

// interface for Math operation
@FunctionalInterface
interface MathOperation {
  int operate(int a, int b);
}

//

class SumOperation implements MathOperation {
  @Override
  public int operate(int a, int b) {
    return a + b;
  }
}