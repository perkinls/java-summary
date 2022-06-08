package lipan.top.notes.watchlistener.javademo;

import java.util.Observable;
import java.util.Observer;

/**
 * @author li.pan
 * @title
 * @Date 2021/11/5
 */ //具体观察者类：空方
class BearObserver implements Observer {
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，空方伤心了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，空方高兴了！");
        }
    }
}
