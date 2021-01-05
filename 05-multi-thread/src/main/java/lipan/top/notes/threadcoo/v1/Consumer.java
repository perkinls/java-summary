package lipan.top.notes.threadcoo.v1;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月18日 13:14:00
 */
public class Consumer implements Runnable {
    private KaoYaResource r;

    Consumer(KaoYaResource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.consume();
        }
    }
}
