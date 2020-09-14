import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainTest {

    @Test
    public void test7() {
        List<Integer> collect = IntStream.range(0, 3).mapToObj(Integer::new).collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void test6() {
        ArrayList<Integer> list = new ArrayList<>();
        int n =123;
        while (n>0){
            list.add(n%10);
            n/=10;
        }
        System.out.println(list);
    }

    @Test
    public void test5() {
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(objects);
    }
    @Test
    public void test() {
        boolean a = false || true&&false;
        System.out.println(a);
    }

    @Test
    public void test2() {
        System.out.println(false&&false);
    }

    @Test
    public void test4() {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(3);
        integers.add(7);
        integers.add(4);
        integers.add(5);
        integers.sort((a,b)->{
            if (a<b){
                return -1;
            }
            if (a>b){
                return 1;
            }
            return 0;
        });

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
