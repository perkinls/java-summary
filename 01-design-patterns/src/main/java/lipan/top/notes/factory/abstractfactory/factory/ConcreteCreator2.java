package lipan.top.notes.factory.abstractfactory.factory;

import lipan.top.notes.factory.abstractfactory.product.ConcreteProductA2;
import lipan.top.notes.factory.abstractfactory.product.ConcreteProductB2;
import lipan.top.notes.factory.abstractfactory.product.ProductA;
import lipan.top.notes.factory.abstractfactory.product.ProductB;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 产品等级为2的具体工厂（有M个产品等级，就应该有M个实现工厂类）
 * @createTime 2020年11月26日 09:38:00
 */
public class ConcreteCreator2 implements Creator {

    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}
