package lipan.top.notes.prototype.shallow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 客户端
 * @createTime 2020年12月13日 20:20:00
 */
public class Client {

    public static void main(String[] args) {
        try {
            PassWord pwd = new PassWord();
            pwd.setPwdType("mm");
            pwd.setPwd("123456");

            List<String> girls = new ArrayList<>();
            girls.add("AA");
            girls.add("BB");

            User user = new User(1, "lp", pwd, girls);

            User user1 = (User) user.clone();
            user1.setName("ll");
            user1.getPwd().setPwd("1111111");
            user1.getGirls().add("CC");

            System.out.println(user.toString() + "|" + user.getPwd().hashCode() + "|" + user.getGirls().hashCode() + "|" + user.hashCode());
            System.out.println(user1.toString() + "|" + user1.getPwd().hashCode() + "|" + user1.getGirls().hashCode() + "|" + user1.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
