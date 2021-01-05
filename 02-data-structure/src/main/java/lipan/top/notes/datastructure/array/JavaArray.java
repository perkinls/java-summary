package lipan.top.notes.datastructure.array;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description Java Array使用
 * @createTime 2020年12月08日 22:53:00
 */
public class JavaArray {
    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i = 0; i<arr.length; i++)
            arr[i] = i;

        //定义数组及数据
        int[] scores = new int[]{100,99,98};
        for (int i = 0; i<scores.length; i++)
            System.out.println(scores[i]);

        // 数组可遍历
        scores[0] = 98;
        for (int score: scores)
            System.out.println(score);
    }
}
