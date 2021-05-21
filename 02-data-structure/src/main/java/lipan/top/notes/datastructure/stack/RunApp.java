package lipan.top.notes.datastructure.stack;

import java.util.Random;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 栈运行类
 * @createTime 2021年05月21日 10:55:00
 * <p>
 * 数组：尾部push添加元素和pop出元素
 * 链表：链表头push添加添加元素和链表头pop出元素
 * </p>
 */
public class RunApp {
    public static void main(String[] args) {

        /**
         * 数组栈和链表栈效率对比,时间复杂度都为O(1)
         * 数据开辟空间，链表new对象，不同的计算机有细微差距
         */
        beCompareStack();
    }

    private static void beCompareStack() {

        int opCount = 100000;

        ArrayStackImpl<Integer> arrayStack = new ArrayStackImpl<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStackImpl<Integer> linkedListStackImpl = new LinkedListStackImpl<>();
        double time2 = testStack(linkedListStackImpl, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

        // 其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作
    }

    // 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(IStack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


}
