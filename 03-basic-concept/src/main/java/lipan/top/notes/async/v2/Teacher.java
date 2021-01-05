package lipan.top.notes.async.v2;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月16日 12:39:00
 */
public class Teacher implements Callback{

    @Override
    public void taskResult(String name) {
        System.out.println("任务:"+name+"完成");
    }

}
