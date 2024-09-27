import java.util.ArrayList;
import java.util.List;

public class HalloJavaMitForEach {
    public void halloJavaMitForEach() {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        strings.add("MitForEach");
        for(String s: strings) {
            System.out.println(s);
        }
        strings.forEach(System.out::println);
    }
}
