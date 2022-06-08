package lipan.top.notes.watchlistener.ringdemo;

import java.util.EventListener;

/**
 * @author li.pan
 * @title
 * @Date 2021/11/5
 */ //抽象观察者类：铃声事件监听器  EventListener：A tagging interface that all event listener interfaces must extend.
interface BellEventListener extends EventListener {
    //事件处理方法，听到铃声
    public void heardBell(RingEvent e);
}
