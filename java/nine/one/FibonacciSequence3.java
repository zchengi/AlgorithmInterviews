package nine.one;

import java.util.Arrays;

/**
 * 斐波那契数列
 * <p>
 * 动态规划
 *
 * @author cheng
 *         2018/12/5 10:55
 */
public class FibonacciSequence3 {

    public int fib(int n) {

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public static void main(String[] args) {

//        int n = 40;
        int n = 1000; // 注意：使用 n=1000 只是为了测试性能，实际上会溢出（斐波那契数列是以指数速度上涨的）
        FibonacciSequence3 fs = new FibonacciSequence3();

        long startTime = System.currentTimeMillis();

        int res = fs.fib(n);

        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time: " + (endTime - startTime) + " ms");
    }
}
