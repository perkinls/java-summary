package lipan.top.notes.factory.factorymethod.reflect.factory;

import lipan.top.notes.factory.factorymethod.product.Product;

/**
 * <li>title: 抽象工厂</li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:55 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: 通过定义工厂父类负责定义创建对象的公共接口，而子类则负责生成具体的对象。</li>
 */
public interface Creator {
    <T extends Product> T createProduct(Class<T> clazz);
}
