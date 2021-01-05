package lipan.top.notes.factory.factorymethod.client;

import lipan.top.notes.factory.factorymethod.factory.ConcreteCreatorA;
import lipan.top.notes.factory.factorymethod.factory.ConcreteCreatorB;
import lipan.top.notes.factory.factorymethod.factory.Creator;
import lipan.top.notes.factory.factorymethod.product.Product;

/**
 * <li>title: 工厂方法 - 又称工厂模式、多态工厂模式和虚拟构造器模式</li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:52 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: 通过定义工厂父类负责定义创建对象的公共接口，而子类则负责生成具体的对象。</li>
 */
public class Client {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.createProduct();
        productA.doSomething();
        productA.doAnything();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.createProduct();
        productB.doSomething();
        productB.doAnything();
    }
}
