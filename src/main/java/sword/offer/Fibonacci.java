package sword.offer;

/**
 * 斐波那契数列
 * @author youtiaoguagua
 * @date 2020/9/7 上午 1:22
 * 输入一个整数 n ，求斐波那契数列的第 n 项。
 * 假定从0开始，第0项为0。(n<=39)
 * 样例
 * 输入整数 n=5
 * 返回 5
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        //f(0) = 0;f(1) = 1;f(2) = 1;f(3) = f(3-1)+f(3-2) = 1+1= 2;
        // f(4) = f(4-1)+f(4-2) = 2+1=3;f(5) = f(5-1)+f(5-2) = 3+2 = 5;
        int a= 0,b=1,c=0;
        for (int i = 0; i <n ; i++) {
            c = a+b;
            a= b;
            b = c;

        }
        return a;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int fibonacci1 = fibonacci.Fibonacci(5);
        System.out.println(fibonacci1);
    }
}
