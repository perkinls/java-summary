package lipan.top.notes.volatilet;

/**
 * @CreatedBy: 'lipan'
 * @Date: 2018/11/14
 * @Description: 一个非线程安全的数值范围类。它包含了一个不变式 —— 下界总是小于或等于上界。
 * https://www.ibm.com/developerworks/cn/java/j-jtp06197.html
 */

public class NumberRange {
    private int lower, upper;

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setLower(int value) {
        if (value > upper)
            throw new IllegalArgumentException("...");
        lower = value;
    }

    public void setUpper(int value) {
        if (value < lower)
            throw new IllegalArgumentException("...");
        upper = value;
    }

}
/**
 * 这种方式限制了范围的状态变量，因此将 lower 和 upper 字段定义为 volatile 类型不能够充分实现类的线程安全；
 * 从而仍然需要使用同步。否则，如果凑巧两个线程在同一时间使用不一致的值执行 setLower 和 setUpper 的话，则
 * 会使范围处于不一致的状态。例如，如果初始状态是 (0, 5)，同一时间内，线程 A 调用 setLower(4) 并且线程 B
 * 调用 setUpper(3)，显然这两个操作交叉存入的值是不符合条件的，那么两个线程都会通过用于保护不变式的检查，
 * 使得最后的范围值是 (4, 3) —— 一个无效值。至于针对范围的其他操作，我们需要使 setLower() 和 setUpper()
 * 操作原子化 —— 而将字段定义为 volatile 类型是无法实现这一目的的。
 */