package lipan.top.notes.threadstop;

/**
 * <p/>
 * <li>title: 线程中止1</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/3/17 10:01 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 1、线程stop强制性中止，破坏线程安全的示例。
 * 2、interrupt()优雅终止线程。
 * </li>
 */
public class ThreadStop1 {
    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();

        thread.start();
        // 休眠1秒，确保i变量自增成功
        Thread.sleep(1000);
        // 错误的终止(强制终止可能导致i和j的结果不一致，破坏线程安全问题)
//        thread.stop();

        // 正确终止
        thread.interrupt();
        while (thread.isAlive()) {
            // 确保线程已经终止
        }
        thread.print();
    }

    static class StopThread extends Thread {
        private int i = 0, j = 0;

        @Override
        public void run() {
            synchronized (this) {
                // 增加同步锁，确保线程安全
                ++i;
                try {
                    // 休眠10秒,模拟耗时操作
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++j;
            }
        }

        /**
         * 打印i和j
         */
        public void print() {
            System.out.println("i=" + i + " j=" + j);
        }
    }

}



