package lipan.top.notes.factory.abstractfactory.factory;

import lipan.top.notes.factory.abstractfactory.product.ProductB;
import lipan.top.notes.factory.abstractfactory.product.ProductA;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 产品族
 * @createTime 2020年11月26日 09:48:00
 */
public interface Creator {
    /**
     * 创建A产品家族
     *
     * @return
     */
    ProductA createProductA();

    /**
     * 创建B产品家族
     *
     * @return
     */
    ProductB createProductB();

    // ...
    // 有N个产品族，在抽象工厂类中就应该有N个创建方法
}
