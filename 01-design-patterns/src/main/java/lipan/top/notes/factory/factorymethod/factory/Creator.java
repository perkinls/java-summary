package lipan.top.notes.factory.factorymethod.factory;

import lipan.top.notes.factory.factorymethod.product.Product;

/**
 * <li>title: 抽象工厂接口</li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:51 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: </li>
 */
public interface Creator {
    Product createProduct();
}
