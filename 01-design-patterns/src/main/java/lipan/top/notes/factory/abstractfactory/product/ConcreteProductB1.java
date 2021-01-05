package lipan.top.notes.factory.abstractfactory.product;


/**
 * @author li.pan
 * @version 1.0.0
 * @Description 产品B1
 * @createTime 2020年11月26日 09:38:00
 */
public class ConcreteProductB1 implements ProductB {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProductB1 doSomething");
    }

    @Override
    public void doAnything() {
        System.out.println("ConcreteProductB1 doAnything");
    }
}
