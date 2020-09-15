package sword.offer.day7;

import java.util.Arrays;

/**
 * 构建乘积数组
 * @author youtiaoguagua
 * @date 2020/9/16 00:37
 * 给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其中B中的元素B[i]=A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 * 样例
 * 输入：[1, 2, 3, 4, 5]
 * 输出：[120, 60, 40, 30, 24]
 * 思考题：
 * 能不能只使用常数空间？（除了输出的数组之外）
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res,1);

        for (int i = 0,p=1; i < n; i++) {
            res[i] *= p;
            p*=A[i];
        }

        for (int i = n-1,p=1; i >=0 ; i--) {
            res[i] *= p;
            p *= A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        int[] multiply1 = multiply.multiply(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(multiply1));
    }
}
