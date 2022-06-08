package lipan.top.notes.watchlistener;

/**
 * @author li.pan
 * @title 启动主类
 * @Date 2021/11/5
 */
public class MainApp {
    public static void main(String[] args) {
        Subject subject=new ConcreteSubject();
        Observer obs1=new ConcreteObserver1();
        Observer obs2=new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}
