package two.six;

/**
 * 动态数组
 *
 * @author cheng
 *         2018/1/28 11:57
 */
public class MyVector<Item> {

    private Item[] data;
    /**
     * 存储数组中可以容纳的最大的元素个数
     */
    private int capacity;
    /**
     * 存储数组中的元素个数
     */
    private int size;

    public MyVector(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        data = (Item[]) new Object[capacity];
    }

    public MyVector() {
        this(10);
    }

    /**
     * Average:O(1)
     */
    public void push(Item e) {
        // 均摊复杂度
        if (size == capacity) {
            resize(2 * capacity);
        }

        data[size++] = e;
    }

    /**
     * 平均复杂度为O(1)
     */
    public Item pop() {
        if (size <= 0) {
            throw new IllegalArgumentException("can not pop for empty vector.");
        }
        Item ret = data[--size];

        // 在size达到静态数组最大容量的1/4时才进行resize
        // resize的容量是当前最大的1/2
        // 防止复杂度的震荡
        if (size == capacity / 4) {
            resize(capacity / 2);
        }
        return ret;
    }

    public Item at(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of bound.");
        }
        return data[index];
    }

    /**
     * 复杂度为 O(n)
     */
    private void resize(int newCapacity) {
        assert newCapacity >= size;

        Item[] newData = (Item[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);

        data = newData;
        capacity = newCapacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        // 注意：Java语言由于JVM内部机制的因素，测量的性能时间有可能是跳跃不稳定的。

        for (int i = 10; i < 26; i++) {
            int n = (int) Math.pow(2, i);

            long startTime = System.currentTimeMillis();
            MyVector<Integer> vec = new MyVector<Integer>();
            for (int num = 0; num <n ; num++) {
                vec.push(num);
            }

            for (int num = 0; num < n; num++) {
                vec.pop();
            }
            long endTime = System.currentTimeMillis();

            System.out.print(2 * n + " operations: \t");
            System.out.println((endTime-startTime)+" ms");
        }
    }
}
