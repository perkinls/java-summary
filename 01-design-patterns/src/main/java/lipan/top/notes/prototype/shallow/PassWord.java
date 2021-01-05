package lipan.top.notes.prototype.shallow;

import java.io.Serializable;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 浅拷贝。具体原型, 实现 Cloneable 接口
 * @createTime 2020年12月13日 20:16:00
 */
public class PassWord implements Serializable, Cloneable {
    private String pwdType;
    private String pwd;

    public String getPwdType() {
        return pwdType;
    }

    public void setPwdType(String pwdType) {
        this.pwdType = pwdType;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Pwd{" +
                "pwdType='" + pwdType + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}