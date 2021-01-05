package lipan.top.notes.async.v2;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月16日 12:40:00
 */
public class Student {
    Callback callback=null;
    //将老师的联系信息给学生
    public void setCallback(Callback callback)
    {
        this.callback=callback;
    }
    public void doTask()
    {
        for(int m=1;m<6;m++)
        {
            callback.taskResult(m+"是张三");
        }
    }
}
