package lipan.top.notes.threadcoo.v2;

import lipan.top.notes.threadcoo.v1.KaoYaResource;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 多生产者多消费者模式
 * @createTime 2020年12月18日 13:21:00
 */
public class MutilProducerConsumer {
    public static void main(String[] args) {
        KaoYaResource r = new KaoYaResource();
        MutilProducer pro = new MutilProducer(r);
        MutilConsumer con = new MutilConsumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();

    }
}
