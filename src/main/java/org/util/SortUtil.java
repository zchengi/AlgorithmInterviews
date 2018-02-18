package org.util;

/**
 * 工具类
 *
 * @author cheng
 *         2018/1/27 15:54
 */
public class SortUtil {

    private SortUtil() {
    }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert n > 0 && rangeL <= rangeR;
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }
        return arr;
    }

    public static Integer[] generateOrderedArray(int n) {
        assert n > 0;
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
