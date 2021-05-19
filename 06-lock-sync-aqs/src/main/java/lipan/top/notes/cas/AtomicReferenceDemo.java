package lipan.top.notes.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 原子更新引用类型
 * @createTime 2021年03月22日 19:58:00
 */
public class AtomicReferenceDemo {
    private static AtomicReference<User> reference = new AtomicReference<User>();

    public static void main(String[] args){
        User user = new User("tom",23);
        reference.set(user);
        User updateUser = new User("ketty",34);
        reference.compareAndSet(user,updateUser);
        System.out.println(reference.get().getName());
        System.out.println(reference.get().getAge());
    }


    static class User{

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
