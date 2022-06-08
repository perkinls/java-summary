package lipan.top.notes.interview;

/**
 * @author li.pan
 * @title
 * @Date 2021/8/31
 */
public class BooleanTest {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println("数据i="+i);
            if(true && false){
                System.out.println("为true");
                continue;
            }
            System.out.println("执行下一次");

        }

    }
}
