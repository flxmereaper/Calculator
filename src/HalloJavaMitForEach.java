import java.util.ArrayList;
import java.util.List;

public class HalloJavaMitForEach {
    public void halloJavaMitForEach() {
        List<String> strings = new ArrayList<>();
        for(String s: strings) {
            System.out.println(s);
        }
        strings.forEach(System.out::println);
        
    }
}
