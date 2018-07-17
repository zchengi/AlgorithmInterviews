package two.two;

/**
 * 运行一个O(n)的程序
 *
 * @author cheng
 *         2018/1/27 14:44
 */
public class Demo {
    public static void main(String[] args) {
        // 数据规模每次增大10倍进行测试
        for (int x = 1; x <= 9; x++) {

            int n = (int) Math.pow(10, x);

            long startTime = System.currentTimeMillis();

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += i;
                sum += i;
            }

            long endTime = System.currentTimeMillis();

            System.out.println("sum = " + sum);
            System.out.println("10^" + x + " : " + (endTime - startTime) + " ms");
            System.out.println("");
        }
    }
}
