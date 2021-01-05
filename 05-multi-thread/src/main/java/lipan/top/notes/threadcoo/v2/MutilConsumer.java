package lipan.top.notes.threadcoo.v2;

import lipan.top.notes.threadcoo.v1.KaoYaResource;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 消费者线程
 * @createTime 2020年12月18日 13:23:00
 */
public class MutilConsumer implements Runnable {
    private KaoYaResource r;

    MutilConsumer(KaoYaResource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.consume();
        }
    }
}
