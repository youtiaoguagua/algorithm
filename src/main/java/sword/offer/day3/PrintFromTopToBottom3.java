package sword.offer.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 之字形打印二叉树
 *
 * @author youtiaoguagua
 * @date 2020/9/10 13:07
 * 请实现一个函数按照之字形顺序从上向下打印二叉树。
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]
 * 8
 * / \
 * 12  2
 * / \
 * 6   4
 * 输出：[[8], [2, 12], [6, 4]]
 */
public class PrintFromTopToBottom3 {

    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> lin = new LinkedList<>();
        if (root == null) {
            return list;
        }

        int index = 1;

        lin.add(root);
        while (!lin.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while (!lin.isEmpty()) {
                TreeNode pop = lin.pop();
                list1.add(pop.val);
                tmp.addFirst(pop);
            }
            list.add(list1);
            boolean add;
            for (TreeNode treeNode : tmp) {
                if (index%2==1){
                    add = treeNode.right==null?false:lin.add(treeNode.right);
                    add = treeNode.left==null?false:lin.add(treeNode.left);
                }else {
                    add = treeNode.left==null?false:lin.add(treeNode.left);
                    add = treeNode.right==null?false:lin.add(treeNode.right);
                }
            }
            index++;

        }
        return list;


    }

    /**
     * 优化版
     */
    public List<List<Integer>> printFromTopToBottom2(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        boolean type = false;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()){
           TreeNode pop = queue.pop();
            if (pop==null){
                if (tmp.isEmpty()){
                    break;
                }
                if (type){
                    Collections.reverse(tmp);
                }
                list.add((List<Integer>) tmp.clone());
                queue.add(null);
                tmp.clear();
                type = !type;
            }else {
                tmp.add(pop.val);
                if (pop.left!=null){

                    queue.add(pop.left);
                }

                if (pop.right!=null){

                    queue.add(pop.right);
                }
            }

        }
        return list;
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
