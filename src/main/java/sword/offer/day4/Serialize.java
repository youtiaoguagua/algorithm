package sword.offer.day4;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 序列化二叉树
 * @author youtiaoguagua
 * @date 2020/9/11 15:00
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 您需要确保二叉树可以序列化为字符串，并且可以将此字符串反序列化为原始树结构。
 * 样例
 * 你可以序列化如下的二叉树
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 *
 * 为："[8, 12, 2, null, null, 6, 4, null, null, null, null]"
 * 注意:
 * 以上的格式是AcWing序列化二叉树的方式，你不必一定按照此格式，所以可以设计出一些新的构造方式。
 */
public class Serialize {


    // Encodes a tree to a single string.
    String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfs(root,builder);
        return builder.toString();
    }

    private void dfs(TreeNode root, StringBuilder builder) {
        if (root==null){
            builder.append("null").append(",");
            return;
        }
        builder.append(root.val).append(",");
        dfs(root.left,builder);
        dfs(root.right,builder);

    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        String[] split = data.split(",");
        TreeNode node = dfsTree(split);
        return node;
    }
    int cur;
    private TreeNode dfsTree(String[] split ) {
        if (cur==split.length){
            return null;
        }

        if (split[cur].equals("null")){
            cur++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(split[cur]));
        cur++;
        root.left = dfsTree(split);
        root.right = dfsTree(split);
        return root;
    }

    public static void main(String[] args) {
        Serialize serialize = new Serialize();
        serialize.deserialize("[8, 12, 2, null, null, 6, 4, null, null, null, null]");
    }

   static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
