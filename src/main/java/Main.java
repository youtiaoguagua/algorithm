import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author youtiaoguagua
 * @date 2020/9/16 20:18
 */
public class Main {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        try(BufferedReader br = new BufferedReader(isr)){
            int num3 = Integer.parseInt(br.readLine());
            int num4 = Integer.parseInt(br.readLine());
            System.out.println("num3 + num4 = "+ (num3+ num4));
        }catch (Exception  e){

        }
    }
}
