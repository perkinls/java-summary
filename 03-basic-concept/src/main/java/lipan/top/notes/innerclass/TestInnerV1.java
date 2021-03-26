package lipan.top.notes.innerclass;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 匿名内部内的使用
 * @createTime 2021年03月26日 16:19:00
 * <p>
 * 内部类可以访问其所在类的属性（包括所在类的私有属性），内部类创建自身对象需要先创建其所在类的对象
 * </p>
 */
public class TestInnerV1 {
    private int num = 100;

    public class Inner {
        private int num = 200;

        public void print() {
            int num = 500;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(TestInnerV1.this.num);
        }
    }

    public static void main(String[] args) {
        TestInnerV1 innerV1 = new TestInnerV1();
        TestInnerV1.Inner in = innerV1.new Inner();
        in.print();
    }

}
