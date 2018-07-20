package six.seven;

import javafx.util.Pair;

import java.util.*;

/**
 * LeetCode 347. Top K Frequent Elements
 * <p>
 * 时间复杂度: O(nlogk)
 * 空间复杂度: O(n + k)
 *
 * @author cheng
 *         2018/7/20 23:00
 */
public class Solution1 {
    public List<Integer> topKFrequent(int[] nums, int k) {

        if (k <= 0) {
            throw new IllegalArgumentException("k should be greater than 0");
        }

        List<Integer> res = new ArrayList<>();

        // 统计每个元素出现的频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 1) + 1);
        }

        if (k > freq.size()) {
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");
        }

        // 扫描 freq，维护当前出现频率最高的k个元素
        // 在优先队列中，按照频率排序，所以数据对是（频率，元素）的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> {
            if (!p1.getKey().equals(p2.getKey())) {
                return p1.getKey() - p2.getKey();
            }
            return p1.getValue() - p2.getValue();
        });

        for (int num : freq.keySet()) {
            int numFreq = freq.get(num);
            if (pq.size() == k) {
                if (numFreq > pq.peek().getKey()) {
                    pq.poll();
                    pq.add(new Pair<>(numFreq, num));
                }
            } else {
                pq.add(new Pair<>(numFreq, num));
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll().getValue());
        }

        return res;
    }

    public static void main(String[] args) {

        int nums[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(new Solution1().topKFrequent(nums, k));
    }
}
