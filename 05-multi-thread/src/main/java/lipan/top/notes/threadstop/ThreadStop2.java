package lipan.top.notes.threadstop;

/**
 * <p/>
 * <li>title: 线程中止2</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/3/17 10:15 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: 通过状态位来判断</li>
 */
public class ThreadStop2 {
    public volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                // 判断是否运行
                while (flag) {
                    System.out.println("运行中");
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 3秒之后，将状态标志改为False，代表不继续运行
        Thread.sleep(3000L);
        flag = false;
        System.out.println("程序运行结束");
    }
}
