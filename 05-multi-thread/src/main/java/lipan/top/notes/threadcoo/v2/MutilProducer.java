package lipan.top.notes.threadcoo.v2;

import lipan.top.notes.threadcoo.v1.KaoYaResource;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 生产者线程
 * @createTime 2020年12月18日 13:22:00
 */
public class MutilProducer implements Runnable {
    private KaoYaResource r;

    MutilProducer(KaoYaResource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.product("北京烤鸭");
        }
    }
}
