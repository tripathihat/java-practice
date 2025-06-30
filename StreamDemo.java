import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

  public static void main(String[] args) {

    // Source , operation (intermediate) and then terminal operation

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    // convert collection into stream

    // to find out even no
    int count = 0;
    for (int i : list) {
      if (i % 2 == 0) {
        count++;
      }
    }
    System.out.println(count);
    // now by stream
    System.out.println(list.stream().filter(x -> x % 2 == 0).count());

    // creating streams

    // 1. from collections
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    Stream<Integer> stream1 = list1.stream();

    // 2. from arrays
    String[] array = { "a", "b", "c" };
    Stream<String> stream2 = Arrays.stream(array);

    // 3. using Stream.of
    Stream<String> stream3 = Stream.of("harshit", "cdac", "noida");

    // 4. infinite streams
    Stream.generate(() -> 1);
    Stream.iterate(1, x -> x + 1);

  }

}
