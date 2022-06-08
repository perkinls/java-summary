package lipan.top.notes.watchlistener.javademo;

import java.util.Observable;

/**
 * @author li.pan
 * @title
 * @Date 2021/11/5
 */ //具体目标类：原油期货
class OilFuturesObservable extends Observable {
    private float price;

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        super.setChanged();  //设置内部标志位，注明数据发生变化
        super.notifyObservers(price);    //通知观察者价格改变了
        this.price = price;
    }
}
