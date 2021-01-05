package lipan.top.notes.prototype.deepcopy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description (深拷贝)具体原型, 实现 Cloneable 接口
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

    /**
     * 深拷贝v1版本, 修改clone() 方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = null;
        try{
            user = (User) super.clone();
        } catch (Exception e){
            e.printStackTrace();
        }

        user.pwd = (PassWord) user.getPwd().clone();
        user.girls = (List<String>) ((ArrayList) user.getGirls()).clone();
        return user;
    }

    /**
     * 深拷贝v2版本, 采用序列化方式优化
     * @return
     * @throws Exception
     */
    public Object deepClone() throws Exception{
        byte[] bytes = null;
        // 序列化
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);){

            //当前这个对象以对象流的方式输出
            oos.writeObject(this);
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        try(ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);) {
            User copyObj = (User) ois.readObject();
            return copyObj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
