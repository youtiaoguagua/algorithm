import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class MainTest {
    @Test
    public void test() {
        boolean a = false || true&&false;
        System.out.println(a);
    }

    @Test
    public void test2() {
        System.out.println(false&&false);
    }
}
