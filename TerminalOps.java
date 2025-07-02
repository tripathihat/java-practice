import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TerminalOps {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    // 1 . collect

    list.stream().skip(1).toList();

    // anymatch , allmatch , nonematch

    boolean b = list.stream().anyMatch(x -> x % 2 == 0);

    // filtering and collecting names
    List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
    System.out.println(names.stream().filter(x -> x.length() > 3).toList());

    // sqaring and sorting numbers
    List<Integer> numbIntegers = Arrays.asList(5, 2, 6, 8, 4, 9, 11, 67, 23);
    System.out.println(numbIntegers.stream().map(x -> x * x).sorted().toList());

    // summing values
    System.out.println("sum:" + numbIntegers.stream().reduce(Integer::sum).get());

    // counting occurrences of a character

    String seString = "Hello World";
    System.out.println(seString.chars().filter(x -> x == 'l').count());

    // stateful and stateless operations
    // lazy

  }
}
