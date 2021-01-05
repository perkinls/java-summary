package lipan.top.notes.builder.v1;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 3.低配版(i5的CPU 、 8G内存 、 500G硬盘 、 薄膜键盘和有线鼠标)
 * @createTime 2020年12月10日 21:32:00
 */
public class LowConfigBuilder implements IComputerConfigBuilder {

    private Computer mComputer;

    public LowConfigBuilder() {
        this.mComputer = new Computer();
    }

    @Override
    public void setCpu() {
        mComputer.setCPU("i5");
    }

    @Override
    public void setMemory() {
        mComputer.setMemory("8G");
    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("500G");
    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("薄膜键盘");
    }

    @Override
    public void setMouse() {
        mComputer.setMouse("有线鼠标");
    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}