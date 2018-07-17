package two.four;

import util.SortUtil;

/**
 * 数据规模倍乘测试binarySearch
 * O(logn)
 *
 * @author cheng
 *         2018/1/27 16:17
 */
public class Test3 {
    public static void main(String[] args) {
        // log2n / logn = (log2 + logn)/logn = 1 + log2/logn
        System.out.println("Test for Binary Search:");
        for (int i = 10; i <= 28; i++) {

            int n = (int) Math.pow(2, i);
            Integer[] arr = SortUtil.generateOrderedArray(n);

            long startTime = System.currentTimeMillis();
            int i1 = MyAlgorithmTester.binarySearch(arr, n, 0);
            System.out.println(i1);
            long endTime = System.currentTimeMillis();

            System.out.print("data size 2^" + i + " = " + n + "\t");
            System.out.println("Time cost: " + (endTime - startTime) + " ms");
        }
    }
}
