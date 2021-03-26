package lipan.top.notes.innerclass;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 内部类不能定义static元素
 * @createTime 2021年03月26日 16:19:00
 * <p>
 * 内部类可以多嵌套
 * </p>
 */
public class TestInnerV5 {
    public class Inner {
        public class Inner1 {
            public class Inner2 {
            }
        }
    }
}
