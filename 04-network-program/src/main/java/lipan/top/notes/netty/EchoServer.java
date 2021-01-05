/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package lipan.top.notes.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Echoes back any received data from a client.
 */
public final class EchoServer {

    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

    public static void main(String[] args) throws Exception {

        // 主线程组, 用于接受客户端的连接，但是不做任何处理，跟老板一样，不做事
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 从线程组, 老板线程组会把任务丢给他，让手下线程组去做任务
        EventLoopGroup workerGroup2 = new NioEventLoopGroup();

        final EchoServerHandler serverHandler = new EchoServerHandler();
        try {
            // 服务端配置
            ServerBootstrap b = new ServerBootstrap();
            /**
             * 1. bind 绑定线程组
             * 2. channel 设定通讯模式为NIO， 同步非阻塞
             * 3. option 设定缓冲区大小， 缓存区的单位是字节
             * 4. childHandler 设置过滤器(childHandler是服务的Bootstrap独有的方法。是用于提供处理对象的。
             *              可以一次性增加若干个处理逻辑。是类似责任链模式的处理方式。
             *              增加A，B两个处理逻辑，在处理客户端请求数据的时候，根据A-》B顺序依次处理)
             * 5. bind 绑定端口(ServerBootstrap可以绑定多个监听端口,多次调用bind方法即可)
             * 6. sync 开始监听逻辑(返回一个ChannelFuture,返回结果代表的是监听成功后的一个对应的未来结果。
             *                  可以使用ChannelFuture实现后续的服务器和客户端的交互。)
             */
            ChannelFuture f = b.group(bossGroup, workerGroup2)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            //p.addLast(new LoggingHandler(LogLevel.INFO));
                            p.addLast(serverHandler);
                        }
                    })
                    .bind(PORT)
                    .sync();
            System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>>>");
            // Wait until the server socket is closed.
            f.channel().closeFuture().sync();
        } finally {
            // Shut down all event loops to terminate all threads.
            bossGroup.shutdownGracefully();
            workerGroup2.shutdownGracefully();
        }
    }
}
