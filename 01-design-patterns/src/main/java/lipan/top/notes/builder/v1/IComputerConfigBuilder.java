package lipan.top.notes.builder.v1;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 2.抽象的电脑组装过程的Builder类
 * @createTime 2020年12月10日 21:27:00
 */
public interface IComputerConfigBuilder {
    /**
     * CPU
     */
    void setCpu();

    /**
     * 内存
     */
    void setMemory();

    /**
     * 磁盘
     */
    void setHardDisk();

    /**
     * 键盘
     */
    void setKeyboard();

    /**
     * 鼠标
     */
    void setMouse();

    /**
     * 电脑
     *
     * @return
     */
    Computer getComputer();
}
