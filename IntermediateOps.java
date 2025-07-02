import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
  public static void main(String[] args) {

    // intermediate operation transform a stream into another stream
    // they are lazy , meaning they donot execute until a terminal operation is
    // invoked
    List<String> names = Arrays.asList("ram", "shyam");
    names.stream().filter(x -> x.startsWith("a"));
    // no filtering at this point until terminal operation is invoked
    long res = names.stream().filter(x -> x.startsWith("a")).count();
    System.out.println("res:" + res);
    // 2 . map

    names.stream().map(x -> x.toUpperCase());

    // sorted
    names.stream().sorted();
    names.stream().sorted((a, b) -> a.length() - b.length());

    // distint

    names.stream().filter(x -> x.startsWith("a")).distinct().count();

    // limit

    System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

    // skip
    System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());

    // peek

  }
}
