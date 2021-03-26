package lipan.top.notes.innerclass;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 内部类不能定义static元素
 * @createTime 2021年03月26日 16:19:00
 * <p>
 * static内部类是内部类中一个比较特殊的情况，Java文档中是这样描述static内部类的：一旦内部类使用static修饰，那么此时这个内部类就升级为顶级类。
 * </p>
 */
public class TestInnerV6 {


    public static class Inner {
        //public static void paint (){
        public static void paint() {
            System.out.println("inner?");

        }

    }

    public static void main(String[] args) {
        //通过这个例子我们发现，static内部类不仅可以在内部定义static元素，而且在构建对象的时候也可以一次完成。
        // 从某种意义上说，static内部类已经不算是严格意义上的内部类了。
        TestInnerV6.Inner innerV6 = new TestInnerV6.Inner();
        innerV6.paint();
    }
}
