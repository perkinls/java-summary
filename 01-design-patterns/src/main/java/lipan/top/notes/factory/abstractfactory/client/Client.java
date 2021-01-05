package lipan.top.notes.factory.abstractfactory.client;

import lipan.top.notes.factory.abstractfactory.factory.ConcreteCreator1;
import lipan.top.notes.factory.abstractfactory.factory.ConcreteCreator2;
import lipan.top.notes.factory.abstractfactory.factory.Creator;
import lipan.top.notes.factory.abstractfactory.product.ProductA;
import lipan.top.notes.factory.abstractfactory.product.ProductB;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 抽象工厂
 * 提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类；具体的工厂负责实现具体的产品实例。
 * @createTime 2020年11月26日 09:31:00
 */
public class Client {
    public static void main(String[] args) {
        Creator creator1 = new ConcreteCreator1();

        ProductA productA1 = creator1.createProductA();
        productA1.doSomething();
        productA1.doAnything();

        ProductB productB1 = creator1.createProductB();
        productB1.doSomething();
        productB1.doAnything();

        Creator creator2 = new ConcreteCreator2();

        ProductA productA2 = creator2.createProductA();
        productA2.doSomething();
        productA2.doAnything();

        ProductB productB2 = creator2.createProductB();
        productB2.doSomething();
        productB2.doAnything();
    }
}
