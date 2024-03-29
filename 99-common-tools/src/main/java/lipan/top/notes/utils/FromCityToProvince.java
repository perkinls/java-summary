package lipan.top.notes.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author li.pan
 * @title
 */
public class FromCityToProvince {

    public static List<String[]> allCity() {

        ArrayList<String[]> allCityList = new ArrayList<String[]>();

        allCityList.add(new String[]{"北京"});
        allCityList.add(new String[]{"上海"});
        allCityList.add(new String[]{"天津"});
        allCityList.add(new String[]{"重庆"});
        allCityList.add(new String[]{"哈尔滨", "齐齐哈尔", "牡丹江", "大庆", "伊春", "双鸭山", "鹤岗", "鸡西", "佳木斯", "七台河", "黑河", "绥化", "大兴安岭"});
        allCityList.add(new String[]{"长春", "延边", "吉林", "白山", "白城", "四平", "松原", "辽源", "大安", "通化"});
        allCityList.add(new String[]{"沈阳", "瓦房店", "盘锦", "大连", "葫芦岛", "旅顺", "本溪", "抚顺", "铁岭", "辽阳", "营口", "阜新", "朝阳", "锦州", "丹东", "鞍山"});
        allCityList.add(new String[]{"呼和浩特", "呼伦贝尔", "锡林浩特", "包头", "赤峰", "海拉尔", "乌海", "鄂尔多斯", "通辽"});
        allCityList.add(new String[]{"石家庄", "唐山", "张家口", "廊坊", "邢台", "邯郸", "沧州", "衡水", "承德", "保定", "秦皇岛"});
        allCityList.add(new String[]{"郑州", "开封", "洛阳", "平顶山", "焦作", "鹤壁", "新乡", "安阳", "濮阳", "许昌", "漯河", "三门峡", "南阳", "商丘", "信阳", "周口", "驻马店"});
        allCityList.add(new String[]{"济南", "威海", "胶南", "章丘", "莱州", "莱西", "蓬莱", "荣成", "胶州", "文登", "青岛", "淄博", "乳山", "即墨", "寿光", "招远", "平度", "曲阜", "临沂", "烟台", "枣庄", "聊城", "济宁", "菏泽", "泰安", "日照", "东营", "德州", "滨州", "莱芜", "潍坊"});
        allCityList.add(new String[]{"太原", "阳泉", "晋城", "晋中", "临汾", "运城", "长治", "朔州", "忻州", "大同", "吕梁"});

        allCityList.add(new String[]{"南京", "句容", "苏州", "江阴", "金坛", "海门", "溧阳", "张家港", "吴江", "昆山", "南通", "太仓", "吴县", "徐州", "宜兴", "镇江", "淮安", "常熟", "盐城", "泰州", "无锡", "连云港", "扬州", "常州", "宿迁"});
        allCityList.add(new String[]{"合肥", "巢湖", "蚌埠", "安庆", "六安", "滁州", "马鞍山", "阜阳", "宣城", "铜陵", "淮北", "芜湖", "毫州", "宿州", "淮南", "池州"});
        allCityList.add(new String[]{"西安", "韩城", "安康", "汉中", "宝鸡", "咸阳", "榆林", "渭南", "商洛", "铜川", "延安"});
        allCityList.add(new String[]{"银川", "固原", "中卫", "石嘴山", "吴忠"});

        allCityList.add(new String[]{"兰州", "嘉峪关", "白银", "庆阳", "酒泉", "天水", "武威", "张掖", "甘南", "临夏", "平凉", "定西", "金昌"});
        allCityList.add(new String[]{"西宁", "海北", "海西", "黄南", "果洛", "玉树", "海东", "海南"});
        allCityList.add(new String[]{"武汉", "宜昌", "黄冈", "恩施", "荆州", "神农架", "十堰", "咸宁", "襄樊", "孝感", "随州", "黄石", "荆门", "鄂州"});
        allCityList.add(new String[]{"长沙", "邵阳", "常德", "郴州", "吉首", "株洲", "娄底", "湘潭", "益阳", "永州", "岳阳", "衡阳", "怀化", "韶山", "张家界"});

        allCityList.add(new String[]{"杭州", "临安", "义乌", "诸暨", "富阳", "湖州", "金华", "宁波", "丽水", "绍兴", "雁荡山", "衢州", "嘉兴", "台州", "舟山", "温州"});
        allCityList.add(new String[]{"南昌", "萍乡", "九江", "上饶", "抚州", "吉安", "鹰潭", "宜春", "新余", "景德镇", "赣州"});
        allCityList.add(new String[]{"福州", "厦门", "龙岩", "南平", "宁德", "莆田", "泉州", "三明", "漳州"});
        allCityList.add(new String[]{"贵阳", "安顺", "赤水", "遵义", "铜仁", "六盘水", "毕节", "凯里", "都匀"});

        allCityList.add(new String[]{"成都", "泸州", "内江", "凉山", "阿坝", "巴中", "广元", "乐山", "绵阳", "德阳", "攀枝花", "雅安", "宜宾", "自贡", "甘孜州", "达州", "资阳", "广安", "遂宁", "眉山", "南充"});
        allCityList.add(new String[]{"广州", "深圳", "潮州", "韶关", "湛江", "惠州", "清远", "东莞", "江门", "茂名", "肇庆", "汕尾", "河源", "揭阳", "梅州", "中山", "德庆", "阳江", "云浮", "珠海", "汕头", "佛山"});
        allCityList.add(new String[]{"南宁", "桂林", "阳朔", "柳州", "梧州", "玉林", "桂平", "贺州", "钦州", "贵港", "防城港", "百色", "北海", "河池", "来宾", "崇左"});
        allCityList.add(new String[]{"昆明", "保山", "楚雄", "德宏", "红河", "临沧", "怒江", "曲靖", "思茅", "文山", "玉溪", "昭通", "丽江", "大理"});

        allCityList.add(new String[]{"海口", "三亚", "儋州", "琼山", "通什", "文昌"});
        allCityList.add(new String[]{"乌鲁木齐", "阿勒泰", "阿克苏", "昌吉", "哈密", "和田", "喀什", "克拉玛依", "石河子", "塔城", "库尔勒", "吐鲁番", "伊宁"});

        allCityList.add(new String[]{"拉萨", "昌都地区", "山南地区", "阿里地区", "那曲地区", "林芝地区", "日喀则地区"});
        allCityList.add(new String[]{"香港", "中西区", "东区", "南区", "湾仔区", "九龙城区", "观塘区", "深水埗区", "黄大仙区", "油尖旺区", "离岛区", "葵青区", "北区", "西贡区", "沙田区", "大埔区", "荃湾区", "屯门区", "元朗区"});
        allCityList.add(new String[]{"澳门", "花地玛堂区", "圣安多尼堂区", "大堂区", "望德堂区", "风顺堂区", "嘉模堂区", "圣方济各堂区"});
        allCityList.add(new String[]{"台湾", "基隆市", "嘉义市", "新竹市", "中华台北", "台中市", "台南市", "新北市", "高雄市", "桃园市"});


        return allCityList;
    }


    //所有省（不确定是否有遗漏），这里写了2个方法，其中一个是简写：
    public static List<String> provinceList() {
        ArrayList<String> list = new ArrayList<String>();

        list.add("北京");
        list.add("上海");
        list.add("天津");
        list.add("重庆");

        list.add("黑龙江");
        list.add("吉林");
        list.add("辽宁");
        list.add("内蒙古");

        list.add("河北");
        list.add("河南");
        list.add("山东");
        list.add("山西");

        list.add("江苏");
        list.add("安徽");
        list.add("陕西");
        list.add("宁夏");

        list.add("甘肃");
        list.add("青海");
        list.add("湖北");
        list.add("湖南");

        list.add("浙江");
        list.add("江西");
        list.add("福建");
        list.add("贵州");

        list.add("四川");
        list.add("广东");
        list.add("广西");
        list.add("云南");

        list.add("海南");
        list.add("新疆");
        list.add("西藏");

        list.add("香港");
        list.add("澳门");
        list.add("台湾");


        return list;
    }

    public static List<String> provinceList2() {
        ArrayList<String> list = new ArrayList<String>();

        list.add("北京市");
        list.add("上海市");
        list.add("天津市");
        list.add("重庆市");

        list.add("黑龙江省");
        list.add("吉林省");
        list.add("辽宁省");
        list.add("内蒙古自治区");

        list.add("河北省");
        list.add("河南省");
        list.add("山东省");
        list.add("山西省");

        list.add("江苏省");
        list.add("安徽省");
        list.add("陕西省");
        list.add("宁夏回族自治区");

        list.add("甘肃省");
        list.add("青海省");
        list.add("湖北省");
        list.add("湖南省");

        list.add("浙江省");
        list.add("江西省");
        list.add("福建省");
        list.add("贵州省");

        list.add("四川省");
        list.add("广东省");
        list.add("广西壮族自治区");
        list.add("云南省");

        list.add("海南省");
        list.add("新疆维吾尔族自治区");
        list.add("西藏自治区");

        list.add("香港");
        list.add("澳门");
        list.add("台湾");
        return list;
    }

    public static String findObjectProvince(String cityName) {
        if (cityName.contains("市")) {
            int index = cityName.indexOf("市");
            cityName = cityName.substring(0, index);

        }
        for (int i = 0; i < allCity().size(); i++) {
            for (int j = 0; j < allCity().get(i).length; j++) {
                if (allCity().get(i)[j].equals(cityName)) {
                    String provinceName = provinceList().get(i);
                    return provinceName;
                }
            }

        }
        return "未知其所属省份";
    }

    /**
     * @param addr 查询的地址
     * @return
     * @throws IOException
     */
    public static Object[] getCoordinate(String addr) throws IOException {
        String lng = null;//经度
        String lat = null;//纬度
        try {
            String address = null;
            try {
                address = java.net.URLEncoder.encode(addr, "UTF-8");
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            String key = "HbdcHqDArM7txfGtTKIgkkiMsV8acVIE";
            String url = String.format("https://api.map.baidu.com/geocoding/v3/?address=%s&output=json&ak=%s", address, key);
            URL myURL = null;
            URLConnection httpsConn = null;
            try {
                myURL = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            InputStreamReader insr = null;
            BufferedReader br = null;
            try {
                httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
                if (httpsConn != null) {
                    insr = new InputStreamReader(httpsConn.getInputStream(), "UTF-8");
                    br = new BufferedReader(insr);
                    String data = null;
                    while ((data = br.readLine()) != null) {
//                        System.out.println(data);
                        JSONObject resStr = (JSONObject) JSONObject.parse(data);
                        JSONObject resultMid = (JSONObject) resStr.get("result");
                        JSONObject location = (JSONObject) resultMid.get("location");
                        lng = String.valueOf(location.get("lng"));
                        lat = String.valueOf(location.get("lat"));

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (insr != null) {
                    insr.close();
                }
                if (br != null) {
                    br.close();
                }
            }
        } catch (Exception e) {

        } finally {
            return new Object[]{lng, lat};
        }

    }


    public static void main(String[] args) throws IOException {

        List<String> provinceList = provinceList();
        List<String[]> cityList = allCity();
        Random rand = new Random();
        for (int i = 1; i <= 1051; i++) {
            int provinceIndex = rand.nextInt(provinceList.size());//生成 1-10 的随机数
            String[] citys = cityList.get(provinceIndex);
            String province = provinceList.get(provinceIndex);
            String city = citys[rand.nextInt(citys.length)];
            Object[] coordinate = getCoordinate(city);
            if(coordinate[0]==null){
                i--;
                continue;
            }
            System.out.println(province + "\t" + city + "\t" + coordinate[0] + "\t" + coordinate[1]);
        }

    }


}