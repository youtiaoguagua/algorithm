package sword.offer.day3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youtiaoguagua
 * @date 2020/9/10 11:06
 */
public class PrintFromTopToBottom1 {
    public List<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> lin = new LinkedList<>();
        if (root==null){
            return list;
        }
        lin.add(root);

        while (!lin.isEmpty()) {
            TreeNode pop = lin.pop();
            list.add(pop.val);
            if (pop.left!=null){
                lin.add(pop.left);
            }
            if (pop.right != null) {
                lin.add(pop.right);
            }
        }
        return list;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
