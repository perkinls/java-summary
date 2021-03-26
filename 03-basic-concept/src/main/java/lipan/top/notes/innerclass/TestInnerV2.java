package lipan.top.notes.innerclass;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 匿名内部内的使用
 * @createTime 2021年03月26日 16:19:00
 * <p>
 * 可以定义内部接口，且可以定义另外一个内部类实现这个内部接口
 * </p>
 */
public class TestInnerV2 {

    public interface Fly{
        void fly();
    }

    public class Inner implements Fly {

        @Override
        public void fly() {
            System.out.println(" I'm super man");
        }
    }

    public static void main(String[] args) {
        TestInnerV2 innerV2 = new TestInnerV2();
        TestInnerV2.Inner in = innerV2.new Inner();
        in.fly();
    }
}
