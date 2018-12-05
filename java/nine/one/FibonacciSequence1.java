package nine.one;

/**
 * 斐波那契数列
 * <p>
 * 递归法
 *
 * @author cheng
 *         2018/12/5 10:31
 */
public class FibonacciSequence1 {

    private int num = 0;

    public int fib(int n) {

        num++;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        FibonacciSequence1 fs = new FibonacciSequence1();

        int n = 40;
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
