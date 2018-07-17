package four.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode 350. Intersection of Two Arrays II
 * <p>
 * map 的使用
 * 时间复杂度: O(len(nums1)+len(nums2))
 * 空间复杂度: O(len(nums1))
 *
 * @author cheng
 *         2018/3/16 21:14
 */
public class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {

        // TreeMap<Integer, Integer> record = new TreeMap<Integer, Integer>();
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            if (record.containsKey(num)) {
                record.put(num, record.get(num) + 1);
            } else {
                record.put(num, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int num : nums2) {
            if (record.containsKey(num) && record.get(num) > 0) {
                result.add(num);
                record.put(num, record.get(num) - 1);
            }
        }

        int[] ret = new int[result.size()];
        int index = 0;
        for (int num : result) {
            ret[index++] = num;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution1().intersect(nums1, nums2)));
    }
}
