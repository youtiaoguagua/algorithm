package sword.offer.day5;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 把数组排成最小的数
 * @author youtiaoguagua
 * @date 2020/9/13 09:27
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组[3, 32, 321]，则打印出这3个数字能排成的最小数字321323。
 * 样例
 * 输入：[3, 32, 321]
 * 输出：321323
 * 注意：输出数字的格式为字符串。
 */
public class PrintMinNumber {
    /**
     * 流简化版
     */
    public String printMinNumber2(int[] nums) {
        if (nums.length==0){
            return "";
        }
        String collect = Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((a, b) -> (a + b).compareTo(b + a))
                .collect(Collectors.joining());
        return collect;
    }


    public String printMinNumber(int[] nums) {
        if (nums.length==0){
            return "";
        }
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings,(a,b)-> (a+b).compareTo((b+a)));
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber printMinNumber = new PrintMinNumber();
        String s = printMinNumber.printMinNumber(new int[]{3, 32, 321});
        System.out.println(s);
    }
}
