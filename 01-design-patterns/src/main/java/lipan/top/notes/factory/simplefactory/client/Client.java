package lipan.top.notes.factory.simplefactory.client;


import lipan.top.notes.factory.simplefactory.product.Product;
import lipan.top.notes.factory.simplefactory.factory.Creator;

/**
 * <li>title: 简易工厂客户端</li>¬
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:50 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。
 * 这种方法的缺点也很明显，违背了设计模式的开闭原则，因为如果你要增加工厂可以初始化的类的时候，你必须对工厂进行改建
 * </li>
 */
public class Client {

    public static void main(String[] args) {
        Product productA = Creator.createProduct("A");
        productA.doSomething();
        productA.doAnything();

        Product productB = Creator.createProduct("B");
        productB.doSomething();
        productB.doAnything();
    }

}
