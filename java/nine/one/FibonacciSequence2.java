package nine.one;

import java.util.Arrays;

/**
 * 斐波那契数列
 * <p>
 * 递归法 + 记忆化搜索
 *
 * @author cheng
 *         2018/12/5 10:48
 */
public class FibonacciSequence2 {

    private int num = 0;

    public int fib(int n) {

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib(n, memo);
    }

    private int fib(int n, int[] memo) {

        num++;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }

        return memo[n];
    }

    public static void main(String[] args) {

//        int n = 40;
        int n = 1000; // 注意：使用 n=1000 只是为了测试性能，实际上会溢出（斐波那契数列是以指数速度上涨的）
        FibonacciSequence2 fs = new FibonacciSequence2();

        long startTime = System.currentTimeMillis();

        int res = fs.fib(n);

        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time: " + (endTime - startTime) + " ms");
        System.out.println("run function fib() " + fs.getNum() + " times.");
    }

    public int getNum() {
        return num;
    }
}
