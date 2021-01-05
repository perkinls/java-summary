package lipan.top.notes.builder.v2;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 建造者模式V2
 * 使用了内部类的方式，将原来自己的类方法变成私有的，而后提供一个静态的内部类来创建对象。
 * 另外通过返回this对象来链式调用，本类同时为对象提供了一个默认值
 * @createTime 2020年12月10日 21:53:00
 */
public class Person {
    /*名字（必须）*/
    private final String name;
    /*性别（必须）*/
    private final String gender;
    /*年龄（非必须）*/
    private final String age;
    /*鞋子（非必须）*/
    private final String shoes;
    /*衣服（非必须）*/
    private final String clothes;
    /*钱（非必须）*/
    private final String money;
    /*房子（非必须）*/
    private final String house;
    /*汽车（非必须）*/
    private final String car;
    /*职业（非必须）*/
    private final String career;

    private Person(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.shoes = builder.shoes;
        this.clothes = builder.clothes;
        this.money = builder.money;
        this.house = builder.house;
        this.car = builder.car;
        this.career = builder.career;
    }


    public static class Builder {
        private final String name;
        private final String gender;
        private String age;
        private String shoes;
        private String clothes;
        private String money;
        private String house;
        private String car;
        private String career;

        public Builder(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder car(String car) {
            this.car = car;
            return this;
        }

        public Builder shoes(String shoes) {
            this.shoes = shoes;
            return this;
        }

        public Builder clothes(String clothes) {
            this.clothes = clothes;
            return this;
        }

        public Builder money(String money) {
            this.money = money;
            return this;
        }

        public Builder house(String house) {
            this.house = house;
            return this;
        }

        public Builder career(String career) {
            this.career = career;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
