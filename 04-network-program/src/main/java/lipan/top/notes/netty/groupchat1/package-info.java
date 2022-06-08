/**
 * @title netty实现一个简单的群聊系统
 * @author li.pan
 * @Date 2022/4/17
 * 服务器端：可以监测用户上线，离线，并实现消息转发功能
 * 客户端：通过 channel 可以无阻塞发送消息给其它所有用户，同时可以接受其它用户发送的消息（有服务器转发得到）
 * 目的：进一步理解 Netty 非阻塞网络编程机制
 */
package lipan.top.notes.netty.groupchat1;