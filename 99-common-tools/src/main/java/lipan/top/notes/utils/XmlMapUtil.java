package lipan.top.notes.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description xml和Map互转工具类
 * @createTime 2020年12月09日 20:21:00
 */
public class XmlMapUtil {
    private final static Logger logger = LoggerFactory.getLogger(XmlMapUtil.class);

    /**
     * xml字符串转map
     *
     * @param xml
     * @return
     */
    public static Map<String, Object> xml2map(String xml) throws DocumentException {
        Document doc = null;
        try {
            //将xml字符串转为document对象
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            logger.error("参数解析失败:{}", e);
            throw e;
        }
        Map<String, Object> map = new HashMap<>();
        if (doc == null) {
            return map;
        } else {
            //获取根节点
            Element rootElement = doc.getRootElement();
            element2map(rootElement, map);
        }
        return map;
    }


    /**
     * 递归原则 :
     * 一个map对应一个xml节点,key为当前xml节点名,value为当前xml节点子集
     * 如果xml节点没有子节点(叶子节点),那么map的key为xml节点名,value为xml节点文本内容
     * 如果xml节点有一个子节点,那么map的key为xml节点名,value为xml节点子集
     * 如果xml节点有多个子节点,对应map的key不存在(每一次),map的key为xml节点名,value为xml节点子集
     * 如果xml节点有多个子节点,对应map的key已存在,且value为map类型(第二次),map的key为xml节点名,值从map类型转为list,而list中添加2份当前xml节点子集
     * 如果xml节点有多个子节点,对应map的key已存在,且value为list类型(第三/多次),那么直接加到list中去.
     *
     * @param ele
     * @param map
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("unchecked")
    private static void element2map(Element ele, Map<String, Object> map) {
        if (null == ele) {
            return;
        }
        String name = ele.getName();

        //判断当前节点是否只含有text或者是空节点
        if (ele.isTextOnly()) {
            map.put(name, ele.getText());
        } else {
            Map<String, Object> mapSub = new HashMap<>();
            //获取当前节点的所有子节点
            List<Element> elements = (List<Element>) ele.elements();

            //利用递归获取节点值
            for (Element eleSub : elements) {
                element2map(eleSub, mapSub);
            }
            Object first = map.get(name);
            //判断
            if (null == first) {
                map.put(name, mapSub);
            } else {
                if (first instanceof List<?>) {
                    ((List<Map<String, Object>>) first).add(mapSub);
                } else {
                    List<Object> listSub = new ArrayList<Object>();
                    listSub.add(first);
                    listSub.add(mapSub);
                    map.put(name, listSub);
                }
            }
        }
    }


    /**
     * map转xml字符串
     *
     * @param map
     * @return
     */
    public static String map2xml(Map<String, Object> map, String rootElement) {
        StringBuffer xmlStr = new StringBuffer("");
        if (ObjectEmptyNullUtil.isEmpty(map))
            return xmlStr.toString();
        xmlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><" + rootElement + ">");
        map2Element(map, xmlStr);
        xmlStr.append("</" + rootElement + ">");
        return xmlStr.toString();
    }

    /**
     * 递归map转xml字符串
     *
     * @param map
     * @param sb
     */
    @SuppressWarnings("unchecked")
    private static void map2Element(Map<String, Object> map, StringBuffer sb) {
        Set<String> set = map.keySet();
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            Object value = map.get(key);
            if (null == value)
                value = "";
            if (value instanceof List<?>) {
                List<Object> list = (List<Object>) map.get(key);
                sb.append("<" + key + ">");
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> hm = (Map<String, Object>) list.get(i);
                    map2Element(hm, sb);
                }
                sb.append("</" + key + ">");
            } else {
                if (value instanceof Map<?, ?>) {
                    sb.append("<" + key + ">");
                    map2Element((Map<String, Object>) value, sb);
                    sb.append("</" + key + ">");
                } else {
                    sb.append("<" + key + ">" + value + "</" + key + ">");
                }

            }
        }
    }



}
