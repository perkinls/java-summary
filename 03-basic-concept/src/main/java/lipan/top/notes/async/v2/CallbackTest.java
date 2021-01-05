package lipan.top.notes.async.v2;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月16日 12:40:00
 */
public class CallbackTest {
    public static void main(String[] args) {
        Student student=new Student();
        student.setCallback(new Teacher());
        student.doTask();
    }
}
