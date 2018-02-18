package org.two.four;

import org.util.SortUtil;

/**
 * 数据规模倍乘测试findMax
 * O(n)
 *
 * @author cheng
 *         2018/1/27 16:06
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("Test for findMax:");
        for (int i = 10; i <= 28; i++) {

            int n = (int) Math.pow(2, i);
            Integer[] arr = SortUtil.generateRandomArray(n, 0, 100000000);

            long startTime = System.currentTimeMillis();
            Integer maxValue = MyAlgorithmTester.findMax(arr, n);
            long endTime = System.currentTimeMillis();

            System.out.print("data size 2^" + i + " = " + n + "\t");
            System.out.println("Time cost: " + (endTime - startTime) + " ms");
        }
    }
}
