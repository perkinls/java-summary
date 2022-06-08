package lipan.top.notes;

/**
 * @author li.pan
 * @title
 * @Date 2021/12/27
 */
public class SubStringTest {
    public static void main(String[] args) {
        String s = "/home/antif/apps/servers/test.jsp";
        System.out.println(s.substring(s.lastIndexOf("/") + 1));
    }
}
