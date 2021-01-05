package lipan.top.notes.async.v1;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月16日 12:33:00
 */
public class CallBackTest {
    /**
     * 1、接口作为方法参数，其实际传入引用指向的是实现类
     * 2、Client的sendMsg方法中，参数为final，因为要被内部类一个新的线程可以使用。这里就体现了异步。
     * 3、调用server的getClientMsg()，参数传入了Client本身（对应第一点）。
     *
     * @param args
     */
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);

        client.sendMsg("Server,Hello~");
    }
}
