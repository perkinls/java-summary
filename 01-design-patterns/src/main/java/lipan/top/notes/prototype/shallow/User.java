package lipan.top.notes.prototype.shallow;

import java.io.Serializable;
import java.util.List;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 浅拷贝。具体原型, 实现 Cloneable 接口
 * @createTime 2020年12月13日 20:19:00
 */
public class User implements Serializable, Cloneable {
    private int id;
    private String name;
    private PassWord pwd;
    private List<String> girls;
    public User(int id, String name, PassWord pwd, List<String> girls){
        this.id = id;
        this.name =name;
        this.pwd =pwd;
        this.girls = girls;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PassWord getPwd() {
        return pwd;
    }
    public void setPwd(PassWord pwd) {
        this.pwd = pwd;
    }
    public List<String> getGirls() {
        return girls;
    }
    public void setGirls(List<String> girls) {
        this.girls = girls;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd=" + pwd +
                ", girls=" + girls +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
