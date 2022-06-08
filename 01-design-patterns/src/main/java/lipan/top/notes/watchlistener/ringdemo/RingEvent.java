package lipan.top.notes.watchlistener.ringdemo;

/**
 * @author li.pan
 * @title
 * @Date 2021/11/5
 */ //铃声事件类：用于封装事件源及一些与事件相关的参数
// EventObject: The root class from which all event state objects shall be derived.
class RingEvent {
    private static final long serialVersionUID = 1L;
    private boolean sound;    //true表示上课铃声,false表示下课铃声

    public RingEvent(Object source, boolean sound) {
        this.sound = sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean getSound() {
        return this.sound;
    }
}
