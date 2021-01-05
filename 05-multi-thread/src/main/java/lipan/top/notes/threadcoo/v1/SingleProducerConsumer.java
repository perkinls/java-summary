package lipan.top.notes.threadcoo.v1;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 单生产者单消费者模式
 * @createTime 2020年12月18日 13:16:00
 */
public class SingleProducerConsumer {
    public static void main(String[] args) {
        KaoYaResource r = new KaoYaResource();

        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        //启动线程
        t0.start();
        t2.start();

    }
}
