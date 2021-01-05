package lipan.top.notes.datastructure;

import lipan.top.notes.datastructure.array.UdfArrayV1;
import lipan.top.notes.datastructure.array.UdfArrayV2;
import lipan.top.notes.datastructure.stack.ArrayStack;
import org.junit.Test;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 数据结构测试
 * @createTime 2020年12月09日 12:55:00
 */
public class DataStructureTest {

    /**
     * 自定义数组测试V1版本
     */
    @Test
    public void UdfArrayV1Test() {
        UdfArrayV1 arr = new UdfArrayV1(20);
        for (int i = 0; i < 10; i++) {
            arr.addList(i);
        }

        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);


        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr);
    }

    /**
     * 自定义数组测试V2版本
     */
    @Test
    public void UdfArrayV2Test() {
        // 使用泛型
        UdfArrayV2<Student> arr = new UdfArrayV2<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 88));
        arr.addLast(new Student("Char", 66));

        System.out.println(arr);
    }

    /**
     * 自定义数组测试V2版本修改后,在新增和删除动态更改数组容量
     */
    @Test
    public void UdfArrayV2ModifyTest() {
        // int类型的包装类
        UdfArrayV2<Integer> arr = new UdfArrayV2<>(5);

        for (int i = 0 ; i < 5 ; i++){
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);


        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr);
    }

    /**
     * 自定义数组栈测试
     */
    @Test
    public void arrayStackTest() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
