package lipan.top.notes.datastructure.linkedlist;

import lipan.top.notes.datastructure.stack.LinkedListStackImpl;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 栈运行类
 * @createTime 2021年05月21日 10:55:00
 * <p>
 *
 * </p>
 */
public class RunApp {
    public static void main(String[] args) {
//        LinkedListV3Run();
//        LinkedListStackRun();
    }


    private static void LinkedListV3Run(){
        LinkedListV3<Integer> linkedList = new LinkedListV3<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

    private static void LinkedListStackRun(){
        LinkedListStackImpl<Integer> stack = new LinkedListStackImpl<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

}
