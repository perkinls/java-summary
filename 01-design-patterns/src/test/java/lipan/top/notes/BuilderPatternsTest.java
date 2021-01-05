package lipan.top.notes;

import lipan.top.notes.builder.v1.Computer;
import lipan.top.notes.builder.v1.Director;
import lipan.top.notes.builder.v1.LowConfigBuilder;
import lipan.top.notes.builder.v2.Person;
import org.junit.Test;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 建造者模式测试类
 * @createTime 2020年12月10日 21:42:00
 */
public class BuilderPatternsTest {

    @Test
    public void buildPatternsV1Test() {
        Director director = new Director();//创建装机人员
        director.setBuilder(new LowConfigBuilder()); //告诉装机人员电脑配置，这里为低配版
        director.createComputer(); //装机人员开始组装
        Computer computer = director.getComputer(); //从装机人员获取组装好的电脑
        System.out.print("电脑配置：" + computer.toString());  //查看电脑配置

//        director.setBuilder(new HighConfigBuilder());
//        director.createComputer();
//        Computer computer = director.getComputer();
//        System.out.print("电脑配置：" + computer.toString());
    }

    @Test
    public void buildPatternsV2Test(){
        Person person = new Person.Builder("张三","男")
                .age("12")
                .money("1000000")
                .car("宝马")
                .build();
        System.out.println(person);
    }
}
