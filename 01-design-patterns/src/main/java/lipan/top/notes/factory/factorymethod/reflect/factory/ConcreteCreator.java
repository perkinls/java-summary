package lipan.top.notes.factory.factorymethod.reflect.factory;

import lipan.top.notes.factory.factorymethod.product.Product;

/**
 * <li>title: 具体工厂</li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:55 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: </li>
 */
public class ConcreteCreator implements Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> clazz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
