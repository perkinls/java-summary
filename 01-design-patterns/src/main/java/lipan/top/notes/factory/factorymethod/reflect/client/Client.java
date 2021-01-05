package lipan.top.notes.factory.factorymethod.reflect.client;

import lipan.top.notes.factory.factorymethod.product.ConcreteProductB;
import lipan.top.notes.factory.factorymethod.reflect.factory.Creator;
import lipan.top.notes.factory.factorymethod.product.ConcreteProductA;
import lipan.top.notes.factory.factorymethod.product.Product;
import lipan.top.notes.factory.factorymethod.reflect.factory.ConcreteCreator;

/**
 * <li>title: 工厂方法 </li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:52 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: 通过定义工厂父类负责定义创建对象的公共接口，而子类则负责生成具体的对象。</li>
 */
public class Client {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();

        Product productA = creator.createProduct(ConcreteProductA.class);
        productA.doSomething();
        productA.doAnything();

        Product productB = creator.createProduct(ConcreteProductB.class);
        productB.doSomething();
        productB.doAnything();
    }
}
