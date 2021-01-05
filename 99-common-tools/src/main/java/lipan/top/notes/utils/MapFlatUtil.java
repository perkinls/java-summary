package lipan.top.notes.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 多层嵌套map对象转扁平化map
 * @createTime 2020年12月10日 14:08:00
 */
public class MapFlatUtil {

    private static final String SEPARATOR = "_";

    /**
     * 深度嵌套map对象转大map（扁平化）
     *
     * @param source     源map
     * @param parentNode 父节点扁平化之后的名字
     * @return map
     */
    public static Map<String, Object> flat(Map<String, Object> source, String parentNode) {
        Map<String, Object> flat = new HashMap<>();
        Set<Map.Entry<String, Object>> set = source.entrySet();
        String prefix = StringUtils.isNotBlank(parentNode) ? parentNode + SEPARATOR : "";
        set.forEach(entity -> {
            Object value = entity.getValue();
            String key = entity.getKey();
            String newKey = prefix + key;
            if (value instanceof Map) {
                flat.putAll(flat((Map) value, newKey));
            } else {
                flat.put(newKey.replaceAll("service_SYS_HEAD_RetMsgArryList_|service_SYS_HEAD_|service_APP_HEAD_|service_BODY_",""), value);
            }
        });
        return flat;
    }
//    public static void main (String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> map2 = new HashMap<>();
//        Map<String, Object> map3 = new HashMap<>();
//        map.put("root", "root");
//        map2.put("root", "root");
//        map2.put("map3", map3);
//        map3.put("root", "root");
//        map.put("map2", map2);
//
//        System.out.println(flat(map, null));
//    }
}
