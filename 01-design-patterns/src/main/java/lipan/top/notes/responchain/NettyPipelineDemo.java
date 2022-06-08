package lipan.top.notes.responchain;

// -----链表形式调用------netty就是类似的这种形式
public class NettyPipelineDemo {
    /**
     * 初始化的时候造一个head，作为责任链的开始，但是并没有具体的处理（通过addLast维护完整的链）
     */
    public HandlerChainContext head = new HandlerChainContext(new AbstractHandler() {
        @Override
        void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
            handlerChainContext.runNext(arg0);
        }
    });

    public void requestProcess(Object arg0) {
        this.head.handler(arg0);
    }

    public void addLast(AbstractHandler handler) {
        HandlerChainContext context = head;
        while (context.next != null) {
            context = context.next;
        }
        context.next = new HandlerChainContext(handler);
    }


    /**
     * @author li.pan
     * @title
     * @Date 2021/11/4
     */ // 处理器抽象类
    abstract static class AbstractHandler {
        /**
         * 处理器，这个处理器将数据处理并向下传递相关参数至下一个调用链路
         */
        abstract void doHandler(HandlerChainContext handlerChainContext, Object arg0); // handler方法
    }

    /**
     * @author li.pan
     * @title
     * @Date 2021/11/4
     */ // 处理器具体实现类
    static class Handler1 extends AbstractHandler {
        @Override
        void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
            arg0 = arg0.toString() + "..handler1的小尾巴.....";
            System.out.println("我是Handler1的实例，我在处理：" + arg0);
            // 继续执行下一个
            handlerChainContext.runNext(arg0);
        }
    }

    /**
     * @author li.pan
     * @title
     * @Date 2021/11/4
     */ // 处理器具体实现类
    static class Handler2 extends AbstractHandler {
        @Override
        void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
            arg0 = arg0.toString() + "..handler2的小尾巴.....";
            System.out.println("我是Handler2的实例，我在处理：" + arg0);
            // 继续执行下一个
            handlerChainContext.runNext(arg0);
        }
    }

    /**
     * handler上下文，我主要负责维护链，和链的执行
     */
    static class HandlerChainContext {
        HandlerChainContext next; // 下一个节点
        AbstractHandler handler;

        public HandlerChainContext(AbstractHandler handler) {
            this.handler = handler;
        }

        void handler(Object arg0) {
            this.handler.doHandler(this, arg0);
        }

        /**
         * 继续执行下一个
         */
        void runNext(Object arg0) {
            if (this.next != null) {
                this.next.handler(arg0);
            }
        }
    }


    public static void main(String[] args) {
        NettyPipelineDemo pipelineChainDemo = new NettyPipelineDemo();
        pipelineChainDemo.addLast(new Handler2());
        pipelineChainDemo.addLast(new Handler1());
        pipelineChainDemo.addLast(new Handler1());
        pipelineChainDemo.addLast(new Handler2());

        // 发起请求
        pipelineChainDemo.requestProcess("火车呜呜呜~~");

    }
}

