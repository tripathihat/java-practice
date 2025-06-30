import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    // day 2

    Function<Integer, Integer> doubleIt = x -> x * 2;
    Function<Integer, Integer> tripleIt = x -> x * 3;

    System.out.println("Double then Triple:" + doubleIt.andThen(tripleIt).apply(5));
    System.out.println("Triple and then Double:" + tripleIt.andThen(doubleIt).apply(10));// same
    System.out.println("Triple it and then double it:" + doubleIt.compose(tripleIt).apply(10));// same

    // Consumer - accepts parameter but no return type
    Consumer<Integer> printConsumer = x -> System.out.println(x);
    printConsumer.accept(50);

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    Consumer<List<Integer>> printList = x -> {
      for (Integer integer : x) {
        System.out.println(integer);
      }
    };
    printList.accept(list);

    // Supplier

    Supplier<String> supplier = () -> "HelloWorld";
    System.out.println(supplier.get());

    // combined example

    Predicate<Integer> isEven = x -> x % 2 == 0;
    Function<Integer, Integer> square = x -> x * x;
    Consumer<Integer> consumer = x -> System.out.println(x);
    Supplier<Integer> supplier2 = () -> 100;

    if (isEven.test(supplier2.get())) {
      consumer.accept(square.apply(supplier2.get()));
    }

    // BiPredicate , BiConsumer, BiFunction

    BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
    BiConsumer<Integer, Integer> consumer2 = (x, y) -> {
      System.out.println(x);
      System.out.println(y);
    };
    BiFunction<String, String, Integer> combinedLength = (x, y) -> (x + y).length();

    System.out.println(isSumEven.test(5, 5));
    consumer2.accept(45, 24);
    System.out.println(combinedLength.apply("hat", "hack"));

    // Method Reference -- use method without invoking in place of lambda

    List<String> listOfNames = Arrays.asList("Ram", "Shyam", "Ghanshyam");
    listOfNames.forEach(x -> System.out.println(x));
    listOfNames.forEach(System.out::println); // method reference

    // constructor reference

    List<String> mobilePhoneStrings = Arrays.asList("Lava", "OnePlus", "Vivo");
    List<MobilePhones> lMobilePhones = mobilePhoneStrings.stream().map(MobilePhones::new)
        .collect(Collectors.toList());

  }
}

class MobilePhones {
  String names;

  public MobilePhones(String names) {
    this.names = names;
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