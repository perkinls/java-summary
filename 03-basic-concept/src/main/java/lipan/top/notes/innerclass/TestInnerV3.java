package lipan.top.notes.innerclass;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 匿名内部内的使用
 * @createTime 2021年03月26日 16:19:00
 * <p>
 * 可以在方法体内定义一个内部类，方法体内的内部类可以完成一个基于虚方法形式的回调操作
 * </p>
 */
public class TestInnerV3 {

    public class Inner {
       public M_Car getCar() {
           class BMW extends M_Car{
               @Override
               public void paint() {
                   super.paint();
               }
           }
           return new BMW();
        }
    }
    public static void main(String[] args) {
        TestInnerV3 innerV3 = new TestInnerV3();
        TestInnerV3.Inner in = innerV3.new Inner();
        in.getCar().paint();
    }
}

class M_Car{
    public void paint(){
        System.out.println("car");
    }
}
