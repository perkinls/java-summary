package lipan.top.notes.watchlistener.javademo;

import java.util.Observer;

/**
 * @author li.pan
 * @title
 * @Date 2021/11/5
 */
public class CrudeOilFutures {
    public static void main(String[] args) {
        OilFuturesObservable oil = new OilFuturesObservable();
        Observer bull = new BullObserver(); //多方
        Observer bear = new BearObserver(); //空方
        oil.addObserver(bull);
        oil.addObserver(bear);
        oil.setPrice(10);
        oil.setPrice(-8);
    }
}

