package lipan.top.notes.responchain;

/**
 * @author liqisi
 * @version v1.1.0
 * @description
 * @date 创建时间：2017/11/18
 */
public class DemandB implements Demand {
    @Override
    public int demandLevel() {
        return 2;
    }

    @Override
    public String detail() {
        return "加一张露一点点的图";
    }
}
