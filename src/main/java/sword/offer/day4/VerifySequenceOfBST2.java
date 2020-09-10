package sword.offer.day4;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 二叉搜索树的后序遍历序列
 * 优化版 解析{@link <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/"> </a>  }
 * @author youtiaoguagua
 * @date 2020/9/10 19:57
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 样例
 * 输入：[4, 8, 6, 12, 16, 14, 10]
 * 输出：true
 */
public class VerifySequenceOfBST2 {

    int[] afterData;

    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return true;
        }

        afterData = sequence;
        return dfs(0, sequence.length - 1);
    }

    private boolean dfs(int start, int end) {
        if (start>=end){
            return true;
        }

        int tmp = start;
        while (afterData[tmp]<afterData[end]){
            tmp++;
        }

        int m = tmp;
        while (afterData[tmp]>afterData[end]){
            tmp++;
        }

        return tmp==end&&dfs(start,m-1)&&dfs(m,end-1);
    }
}
