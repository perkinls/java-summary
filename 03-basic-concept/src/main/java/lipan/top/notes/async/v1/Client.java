package lipan.top.notes.async.v1;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月16日 12:31:00
 */
public class Client implements CSCallBack {

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg(final String msg) {
        System.out.println("客户端：发送的消息为：" + msg);
        new Thread(() -> server.getClientMsg(Client.this, msg)).start();
        System.out.println("客户端：异步发送成功");
    }

    @Override
    public void process(String status) {
        System.out.println("客户端：服务端回调状态为：" + status);
    }
}