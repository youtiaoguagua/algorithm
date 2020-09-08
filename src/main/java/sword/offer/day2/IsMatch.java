package sword.offer.day2;

import java.util.Arrays;

/**
 * 正则表达式匹配
 * @author youtiaoguagua
 * @date 2020/9/8 下午 1:35
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a","a*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 * 样例
 * 输入：
 * s="aa"
 * p="a*"
 * 输出:true
 */
public class IsMatch {
    boolean[][] dp;
    private String s;
    private String p;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        dp =  new boolean[s.length()+1][p.length()+1];
        boolean dfs2 = dfs(0, 0);
        return  dfs2;
    }

    private boolean dfs(int x, int y) {
        if (dp[x][y]!=false){
            return dp[x][y];
        }
        if (y==p.length()){
            return dp[x][y] = x==s.length();
        }

        boolean firstAns = x<s.length()&&(s.charAt(x)==p.charAt(y)||p.charAt(y)=='.');
        if (y+1<p.length()&&p.charAt(y+1)=='*'){
            dp[x][y] = dfs(x,y+2)||firstAns&&dfs(x+1,y);
        }else {
            dp[x][y] = firstAns && dfs(x + 1, y + 1);
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        boolean aa = isMatch.isMatch("aa", "b*");
        System.out.println(aa);
    }
}
