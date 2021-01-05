package lipan.top.notes.factory.factorymethod.factory;

import lipan.top.notes.factory.factorymethod.product.ConcreteProductB;
import lipan.top.notes.factory.factorymethod.product.Product;

/**
 * <li>title: 具体工厂-B</li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:51 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: </li>
 */
public class ConcreteCreatorB implements Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}
