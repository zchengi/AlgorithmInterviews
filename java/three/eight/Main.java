package three.eight;

import java.lang.reflect.Method;

/**
 * 比较这个工程中 Solution1, Solution2, Solution3, Solution4 和 Solution5 的算法运行效率
 *
 * @author cheng
 *         2018/3/10 23:28
 */
public class Main {
    public static void testPerformance(String algoClassName, String algoName, String s) {

        try {
            Class algoClass = Class.forName("three.eight." + algoClassName);
            Object solution = algoClass.newInstance();

            // 通过排序函数的Class对象获得排序方法
            Method algoMethod = algoClass.getMethod(algoName, String.class);

            long startTime = System.currentTimeMillis();
            // 调用算法
            Object resObj = algoMethod.invoke(solution, s);
            long endTime = System.currentTimeMillis();

            int res = (Integer) resObj;
            System.out.print(algoClassName + " : res = " + res + " ");
            System.out.println("Time = " + (endTime - startTime) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int n = 10000000;

        StringBuilder s = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            s.append((char) (Math.random() * 95 + 32));
        }

        System.out.println("Test 10,000,000 length of completely random string: ");
        testPerformance("Solution1", "lengthOfLongestSubstring", s.toString());
        testPerformance("Solution2", "lengthOfLongestSubstring", s.toString());
        testPerformance("Solution3", "lengthOfLongestSubstring", s.toString());
        testPerformance("Solution4", "lengthOfLongestSubstring", s.toString());
        // 数据量大的时候效率更好
        testPerformance("Solution5", "lengthOfLongestSubstring", s.toString());
    }
}
