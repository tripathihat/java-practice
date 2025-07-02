import java.util.List;
import java.util.stream.Stream;

public class ParrelStream {

  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
    List<Long> factorialList = list.stream().map(ParrelStream::factorial).toList();
    long endTime = System.currentTimeMillis();
    System.out.println("Time Taken: " + (endTime - startTime) + " ms");

    // parallel stream

    startTime = System.currentTimeMillis();
    factorialList = list.parallelStream().map(ParrelStream::factorial).toList();
    endTime = System.currentTimeMillis();
    System.out.println("Time Taken parallel stream : " + (endTime - startTime) + " ms");

    // cumulative sum

  }

  private static long factorial(int n) {
    long results = 1;
    for (int i = 2; i <= n; i++) {
      results *= i;
    }
    return results;
  }
}
