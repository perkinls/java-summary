package lipan.top.notes.factory.factorymethod.product;


/**
 * <li>title: 具体产品-B</li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:52 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: </li>
 */
public class ConcreteProductB implements Product {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProductB doSomething");

    }

    @Override
    public void doAnything() {
        System.out.println("ConcreteProductB doAnything");
    }
}
