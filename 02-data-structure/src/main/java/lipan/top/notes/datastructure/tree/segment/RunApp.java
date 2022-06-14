package lipan.top.notes.datastructure.tree.segment;

/**
 * @author li.pan
 * @title 测试线段树
 * @Date 2022/6/13
 */
public class RunApp {

    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);

        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }
}
