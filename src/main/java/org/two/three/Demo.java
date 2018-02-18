package org.two.three;

/**
 * 常见的复杂度分析
 *
 * @author cheng
 *         2018/1/27 15:08
 */
public class Demo {

    /**
     * O(1)
     */
    private static void swap(Object[] arr, int i, int j) {
        if (i < 0 || i >= arr.length) {
            throw new IllegalArgumentException("i is out of bound.");
        }
        if (j <= 0 || j >= arr.length) {
            throw new IllegalArgumentException("j is out of bound.");
        }

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * O(n)
     */
    private static int sum(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater or equal to zero.");
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret += i;
        }
        return ret;
    }

    /**
     * O(n)
     */
    private static void reverse(Object[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            swap(arr, i, n - i - 1);
        }
    }

    /**
     * O(n^2)
     * <p>
     * (n-1)+(n-2)+(n-3)+...+0
     * = (o+n-1)*n/2
     * = (1/2)n*(n-1)
     * = 1/2*n^2-1/2n
     * = O(n^2)
     */
    private static void selectionSort(Comparable arr[], int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(minIndex) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * O(n)
     * 多重循环不一定就是O(n^2)级别
     */
    private static void printInformation(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 30; j++) {
                System.out.println("Class " + i + " - " + "No. " + j);
            }
        }
    }

    /**
     * O(logn)
     * 二分查找法：
     * 在 n 个元素中寻找;
     * 在 n/2 个元素中寻找;
     * 在 n/4 个元素中寻找;
     * .......
     * 在 1 个元素中寻找;
     * <p>
     * n经过几次"除以2"操作后等于1？
     * log2n = O(logn)
     */
    private static int binarySearch(Comparable arr[], int n, int target) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) < mid) l = mid + 1;
            if (arr[mid].compareTo(target) > 0) r = mid - 1;
            else return mid;
        }
        return -1;
    }

    /**
     * O(logn)
     */
    private static String intToString(int num) {
        StringBuilder s = new StringBuilder("");
        String sign = "+";
        if (num < 0) {
            num = -num;
            sign = "-";
        }

        while (num != 0) {
            s.append(Character.getNumericValue('0') + num % 10);
            num /= 10;
        }

        if (s.length() == 0) {
            s.append('0');
        }

        s.reverse();
        return "-".equals(sign) ? sign + s.toString() : s.toString();
    }

    /**
     * O(nlogn)
     */
    public static void hello(int n) {
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 1; i < n; i++) {
                System.out.println("Hello,Algorithm!");
            }
        }
    }

    /**
     * O(sqrt(n))
     * 判断一个数是不是素数
     */
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int x = 3; x * x <= num; x += 2) {
            if (num % x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(intToString(123));
        System.out.println(intToString(0));
        System.out.println(intToString(-123));

        System.out.println();

        System.out.println(isPrime(137) ? "137 is a prime." : "137 is not a prime.");

        System.out.println(isPrime(121) ? "121 is a prime." : "121 is not a prime.");
    }
}
