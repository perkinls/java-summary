package lipan.top.notes.factory.simplefactory.factory;


import lipan.top.notes.factory.simplefactory.product.ConcreteProductA;
import lipan.top.notes.factory.simplefactory.product.ConcreteProductB;
import lipan.top.notes.factory.simplefactory.product.Product;

/**
 * <li>title: 工厂</li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:39 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 负责实现创建所有实例的内部逻辑，并提供一个外界调用的方法，创建所需的产品对象。
 * </li>
 */
public class Creator {

    public static Product createProduct(String type) {
        Product product = null;
        switch (type) {
            case "A":
                product = new ConcreteProductA();
                break;
            case "B":
                product = new ConcreteProductB();
                break;
        }
        return product;
    }
}
