package six.six;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueue 学习
 *
 * @author cheng
 *         2018/7/18 19:45
 */
public class Main {
    public static void main(String[] args) {

        // 默认的 PriorityQueue，底层是最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 随机生成10个范围在 [0, 100) 的数，添加到 pq
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq.add(num);
            System.out.println("insert " + num + " in priority queue.");
        }

        // 依次取出堆顶元素
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

        System.out.println();
        System.out.println();


        // 使用 lambda 表达式，创建底层是最大堆的 PriorityQueue
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq2.add(num);
            System.out.println("insert " + num + " in priority queue.");
        }

        while (!pq2.isEmpty()) {
            System.out.print(pq2.poll() + " ");
        }

        System.out.println();
        System.out.println();


        // 创建自定义的 Comparator ，创建个性化的 PriorityQueue
        // 注意：也可以使用 lambda 表达式，在这里只是为了演示 PriorityQueue 的不同用法
        // 同理，上一个例子也可以使用自定义的 Comparator 的方式完成

        class myCmp implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b) {
                if (a % 10 != b % 10) {
                    return a % 10 - b % 10;
                }
                return a - b;
            }
        }

        // PriorityQueue<Integer> pq3 = new PriorityQueue<>(new myCmp());
        PriorityQueue<Integer> pq3 = new PriorityQueue<>((a, b) -> {
            if (a % 10 != b % 10) {
                return a % 10 - b % 10;
            }
            return a - b;
        });

        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq3.add(num);
            System.out.println("insert " + num + " in priority queue.");
        }

        while (!pq3.isEmpty()) {
            System.out.print(pq3.poll() + " ");
        }
    }
}
