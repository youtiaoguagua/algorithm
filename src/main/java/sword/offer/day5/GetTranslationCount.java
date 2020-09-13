package sword.offer.day5;

/**
 * 把数字翻译成字符串
 *
 * @author youtiaoguagua
 * @date 2020/9/13 12:41
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0翻译成”a”，1翻译成”b”，……，11翻译成”l”，……，25翻译成”z”。
 * 一个数字可能有多个翻译。例如12258有5种不同的翻译，它们分别是”bccfi”、”bwfi”、”bczi”、”mcfi”和”mzi”。
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 * 样例
 * 输入："12258"
 * 输出：5
 */
public class GetTranslationCount {

    private char[] chars;
    int count = 0;

    public int getTranslationCount(String s) {
        if (s.length()==1){
            return 1;
        }
        chars = s.toCharArray();
        dfs(0, 0);
        dfs(0, 1);
        return count;
    }

    private void dfs(int left, int right) {
        if (left != right) {
            int i = chars[left] - '0';
            int j = chars[right] - '0';
            if (i==0){
                return;
            }
            int res = i * 10 + j + 97;
            if (res > 122) {
                return;
            }
        }
        if (right == chars.length - 1) {
            count++;
            return;
        }

        if (right + 2 <= chars.length - 1) {
            dfs(right + 1, right + 2);
        }

        if (right + 1 <= chars.length - 1) {
            dfs(right + 1, right + 1);
        }
    }

    /**
     * 状态转移方程
     */
    public int getTranslationCount2(String s) {
        int[] dp = new int[s.length()+1];
        char[] chars = s.toCharArray();
        dp[0] =1;
        dp[1] =1;
        for (int i = 2; i <= chars.length; i++) {
            dp[i] = dp[i-1];
            int j = chars[i - 1] - '0' + (chars[i - 2] - '0') * 10;
            if (j >= 10 && j <= 25) {
                dp[i] +=dp[i-2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        GetTranslationCount getTranslationCount = new GetTranslationCount();
        int translationCount = getTranslationCount.getTranslationCount2("12345");
        System.out.println(translationCount);

    }
}
