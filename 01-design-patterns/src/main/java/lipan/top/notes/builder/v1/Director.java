package lipan.top.notes.builder.v1;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 4.Director是建造者模式的核心，调用具体建造者来创建不通配置的电脑
 * @createTime 2020年12月10日 21:38:00
 */
public class Director {
    private IComputerConfigBuilder mBuilder;

    /**
     * setBuilder来告诉需要什么配置电脑
     *
     * @param builder
     */
    public void setBuilder(IComputerConfigBuilder builder) {
        this.mBuilder = builder;
    }

    /**
     * 一步步组装电脑
     */
    public void createComputer() {
        mBuilder.setCpu();
        mBuilder.setMemory();
        mBuilder.setHardDisk();
        mBuilder.setKeyboard();
        mBuilder.setMouse();
    }

    /**
     * 获取组装后的电脑
     *
     * @return
     */
    public Computer getComputer() {
        return mBuilder.getComputer();
    }
}
