package sword.offer.day4;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author youtiaoguagua
 * @date 2020/9/10 19:57
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 样例
 * 输入：[4, 8, 6, 12, 16, 14, 10]
 * 输出：true
 */
public class VerifySequenceOfBST {

    private int[] afterData;
    private int[] midData;
    private HashMap<Integer, Integer> map;

    /**
     * 遍历二叉搜索树时，中序遍历为二叉树搜素树的排序；
     */
    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return true;
        }
        afterData = sequence.clone();
        Arrays.sort(sequence);
        midData = sequence;
        map = new HashMap<>();
        for (int i = 0; i < midData.length; i++) {
            map.put(midData[i], i);
        }
        try {
            TreeNode dfs = dfs(0, afterData.length - 1, 0, midData.length - 1);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public TreeNode dfs(int afterStart, int afterEnd, int midStart, int midEnd) {
        if (afterStart > afterEnd) {
            return null;
        }

        TreeNode treeNode = new TreeNode(afterData[afterEnd]);
        Integer integer = map.get(afterData[afterEnd]);
        TreeNode right = dfs(afterEnd - midEnd + integer, afterEnd - 1, integer + 1, midEnd);
        TreeNode left = dfs(afterStart, afterStart + integer - midStart - 1, midStart, integer - 1);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }


    public static void main(String[] args) {
        VerifySequenceOfBST verifySequenceOfBST = new VerifySequenceOfBST();
        boolean b = verifySequenceOfBST.verifySequenceOfBST(new int[]{1, 8, 3, 2, 5, 6});
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
