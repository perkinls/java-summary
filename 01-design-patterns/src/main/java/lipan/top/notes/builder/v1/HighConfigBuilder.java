package lipan.top.notes.builder.v1;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 3.高配版(i7的CPU 、 16G内存 、 1T硬盘 、 机械键盘和无线鼠标)
 * @createTime 2020年12月10日 21:35:00
 */
public class HighConfigBuilder implements IComputerConfigBuilder {

    private Computer mComputer;

    public HighConfigBuilder() {
        this.mComputer = new Computer();
    }

    @Override
    public void setCpu() {
        mComputer.setCPU("i7");
    }

    @Override
    public void setMemory() {
        mComputer.setMemory("16G");
    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("1T");
    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("机械键盘");
    }

    @Override
    public void setMouse() {
        mComputer.setMouse("无线鼠标");
    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}

