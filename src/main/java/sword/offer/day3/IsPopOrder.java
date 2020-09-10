package sword.offer.day3;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * @author youtiaoguagua
 * @date 2020/9/10 09:38
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 注意：若两个序列长度不等则视为并不是一个栈的压入、弹出序列。若两个序列都为空，则视为是一个栈的压入、弹出序列。
 * 样例
 * 输入：[1,2,3,4,5]
 *       [4,5,3,2,1]
 *
 * 输出：true
 */
public class IsPopOrder {

    public boolean isPopOrder(int [] pushV,int [] popV) {
        if (pushV.length!= popV.length){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for (int i = 0; i < pushV.length; i++) {
           if (pushV[i] == popV[index]){
               index++;
            }else if (!stack.isEmpty()&&popV[index]==stack.peek()){
                stack.pop();
                index++;
                i--;
            }
            else {
                stack.push(pushV[i]);
                continue;
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            Integer pop = stack.pop();
            if (pop!=popV[index]){
                return false;
            }
            index++;
        }
        return true;

    }

    public static void main(String[] args) {
        IsPopOrder isPopOrder = new IsPopOrder();
//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//[1, 3, 9, 10, 8, 7]
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] b = {2, 3, 1, 4, 7, 6, 5, 8, 11, 10, 9, 15, 14, 13, 12};
        boolean popOrder = isPopOrder.isPopOrder(a,b);
        System.out.println(popOrder);
    }
}
