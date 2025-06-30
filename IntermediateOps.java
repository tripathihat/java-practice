import java.util.Arrays;
import java.util.List;

public class IntermediateOps {
  public static void main(String[] args) {

    // intermediate operation transform a stream into another stream
    // they are lazy , meaning they donot execute until a terminal operation is
    // invoked
    List<String> names = Arrays.asList("ram", "shyam");
    names.stream().filter(x -> x.startsWith("a"));
    // no filtering at this point until terminal operation is invoked
    long res = names.stream().filter(x -> x.startsWith("a")).count();

    //
  }
}
