package lipan.top.notes.innerclass;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 匿名内部内的使用
 * @createTime 2021年03月26日 16:19:00
 * <p>
 * 与static内部类不同，内部接口自动具备静态属性。也就是说，普通类是可以直接实现内部接口的
 * </p>
 */
public class TestInnerV7 {
    public interface Fly{
        void fly();
    }

}
class superMan implements TestInnerV7.Fly{

    @Override
    public void fly() {
        System.out.println("I'm superMan");
    }
}