package lipan.top.notes.datastructure.queue;

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

//        runArrayQueue();
//
//        runLoopQueue();

        /**
         * 数组队列：入队O(1),出队O(n)
         * 栈队列：入队O(1),出队O(1)
         */
        runCompareQueue();


    }

    public static void runArrayQueue() {

        ArrayQueueImpl<Integer> queue = new ArrayQueueImpl<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println("移除后" + queue);
            }
        }
    }


    public static void runLoopQueue() {

        LoopQueueImpl<Integer> queue = new LoopQueueImpl<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }


    public static void runCompareQueue() {

        int opCount = 100000;

        ArrayQueueImpl<Integer> arrayQueue = new ArrayQueueImpl<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueueImpl<Integer> loopQueue = new LoopQueueImpl<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueueImpl<Integer> linkedListQueueImpl = new LinkedListQueueImpl<>();
        double time3 = testQueue(linkedListQueueImpl, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(IQueue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

}
