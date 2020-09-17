import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author youtiaoguagua
 * @date 2020/9/16 20:18
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );
        StringTokenizer tokenizer = new StringTokenizer("");
        int last = 0;
        int count=10;
        while (count-- > 0) {
            if (! tokenizer.hasMoreTokens() ) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            last = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(last);
    }
}
