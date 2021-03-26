package lipan.top.notes.innerclass;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 内部类不能定义static元素
 * @createTime 2021年03月26日 16:19:00
 * <p>
 * 内部类不能定义static元素
 * </p>
 */
public class TestInnerV4 {


    public class Inner {
        //public static void paint (){
        public void paint() {

        }

    }

    public static void main(String[] args) {
        TestInnerV4 innerV4 = new TestInnerV4();
        TestInnerV4.Inner in = innerV4.new Inner();
        in.paint();
    }
}
