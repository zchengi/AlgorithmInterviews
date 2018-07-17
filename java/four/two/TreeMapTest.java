package four.two;

import java.util.TreeMap;

/**
 * 测试使用Java中的 TreeMap
 *
 * @author cheng
 *         2018/3/16 21:27
 */
public class TreeMapTest {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> myMap = new TreeMap<Integer, Integer>();
        if (myMap.containsKey(42)) {
            System.out.println("Element 42 is in the map.");
        } else {
            System.out.println("Can not find element 42.");
        }
        System.out.println();

        // 输出 null 这里是 key 不存在的意思
        System.out.println(myMap.get(42));
        System.out.println();

        // Java中不存在C++中默认的访问 key 即添加默认 (key,value) 的行为
        // 以下代码仍然无法找到42
        if (myMap.containsKey(42)) {
            System.out.println("Element 42 is in the map.");
        } else {
            System.out.println("Can not find element 42.");
        }
        System.out.println();

        myMap.put(42, 0);
        myMap.put(42, myMap.get(42) + 1);
        // 输出 1
        System.out.println(myMap.get(42));
        if (myMap.containsKey(42)) {
            System.out.println("Element 42 is in the map.");
        } else {
            System.out.println("Can not find element 42.");
        }
        System.out.println();

        myMap.put(42, myMap.get(42) - 1);
        // 输出 0
        System.out.println(myMap.get(42));
        //注意：key 对应的值为 0，不代表 key 不存在  这里是 key 对应的值为 0 的意思
        if (myMap.containsKey(42)) {
            System.out.println("Element 42 is in the map.");
        } else {
            System.out.println("Can not find element 42.");
        }
        System.out.println();

        // 注意：也不可以为 key 对应的值设置 null 来删除一个 key  这里是 key 对应的值为 null 的意思
        myMap.put(42, null);
        System.out.println(myMap.get(42));
        if (myMap.containsKey(42)) {
            System.out.println("Element 42 is in the map.");
        } else {
            System.out.println("Can not find element 42.");
        }
        System.out.println();


        // 使用 remove() 删除一个 key
        myMap.remove(42);
        if (myMap.containsKey(42)) {
            System.out.println("Element 42 is in the map.");
        } else {
            System.out.println("Can not find element 42.");
        }
        System.out.println();

    }
}
