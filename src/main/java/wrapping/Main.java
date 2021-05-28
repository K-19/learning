package wrapping;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InstrumentedSet<Integer> s = new InstrumentedSet<>(new HashSet<>(1000));
        s.add(4);
        s.add(16);
        s.add(64);
        System.out.println(s.getAddCount());
    }
}
