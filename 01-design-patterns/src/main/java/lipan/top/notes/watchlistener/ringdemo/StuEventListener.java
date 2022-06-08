package lipan.top.notes.watchlistener.ringdemo;

/**
 * @author li.pan
 * @title
 * @Date 2021/11/5
 */ //具体观察者类：学生事件监听器
class StuEventListener implements BellEventListener {
    public void heardBell(RingEvent e) {
        if (e.getSound()) {  // 接口回调方式实现
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}
