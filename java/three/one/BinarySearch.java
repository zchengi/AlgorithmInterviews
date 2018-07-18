package three.one;

import util.SortUtil;

/**
 * 二分查找实现
 *
 * @author cheng
 *         2018/2/18 13:00
 */
public class BinarySearch {
    public static int binarySearch(Comparable[] arr, Comparable target) {

        // 在[l...r]的范围里寻找target
        int l = 0, r = arr.length - 1;
        // 当 l == r 时，区间[l...r]依然是有效的，所以应该继续查找
        while (l <= r) {
            // int mid = (r + l) / 2;
            int mid = l + (r - l) / 2;
            int cmp = arr[mid].compareTo(target);
            // target在[mid+1...r]中
            if (cmp < 0) l = mid + 1;
                // target在[l...mid-1]中
            else if (cmp > 0) r = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static int binarySearch2(Comparable[] arr, Comparable target) {

        // 在[l...r)的范围里寻找target
        int l = 0, r = arr.length;
        // 当 l == r 时，区间[l...r)依然是有效的，所以应该继续查找
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cmp = arr[mid].compareTo(target);

            // target在[mid+1...r)中
            if (cmp < 0) l = mid + 1;
                // target在[l...mid-1)中
            else if (cmp > 0) r = mid;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = (int) Math.pow(10, 7);
        Integer[] data = SortUtil.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            if (i != binarySearch(data, i) && i != binarySearch2(data, i)) {
                throw new IllegalArgumentException("Search i failed!");
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + "ms");
    }
}
