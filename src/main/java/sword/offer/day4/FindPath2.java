package sword.offer.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * @author youtiaoguagua
 * @date 2020/9/11 00:34
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 样例
 * 给出二叉树如下所示，并给出num=22。
 *       5
 *      / \
 *     4   6
 *    /   / \
 *   12  13  6
 *  /  \    / \
 * 9    1  5   1
 * 输出：[[5,4,12,1],[5,6,6,5]]
 */
public class FindPath2 {

    private int sum;
    private ArrayList<List<Integer>> list;
    ArrayList<Integer> path = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int sum) {
        this.sum = sum;
        list = new ArrayList<>();

        dfs(root,sum);
        return list;
    }

    private void dfs(TreeNode root, int sum) {
        if (root==null){
            return;
        }
        sum -=root.val;
        path.add(root.val);
        if (sum==0&&root.left==null&&root.right==null){
            list.add((ArrayList)path.clone());
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        path.remove(path.size()-1);
    }


    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
