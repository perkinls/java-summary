package lipan.top.notes.log;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description Log4j工具类
 * @createTime 2020年12月08日 20:50:00
 */
public class Log4jUtil {

    /**
     * 设置Log4j日志级别
     *
     * @param logLevel
     * @param logDir
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void configure(String logLevel, String logDir) throws FileNotFoundException, IOException {

        Properties prop = new Properties();

        ResourceBundle rb = ResourceBundle.getBundle("conf-log4j");
        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String val = rb.getString(key);
            if (val.contains("${log_level}")) {
                prop.put(key, val.replaceAll("\\$\\{log_level\\}", logLevel));
            } else if (val.contains("${log_dir}")) {
                prop.put(key, val.replaceAll("\\$\\{log_dir\\}", logDir));
            } else {
                prop.put(key, val);
            }
        }

        // 使配置生效
        PropertyConfigurator.configure(prop);

    }

    /**
     * 设置Log4j日志级别
     *
     * @param logLevel
     * @param logDir
     * @param configType
     * @param watchEnabled
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void configure(String logLevel, String logDir, String configType, boolean watchEnabled) throws FileNotFoundException, IOException {

        System.setProperty("log_level", logLevel);
        System.setProperty("log_dir", logDir);
        if ("xml".equals(configType)) {
            String path = getFilePath("/conf-log4j.xml");

            if (watchEnabled) {
                DOMConfigurator.configureAndWatch(path);
            } else {
                DOMConfigurator.configure(path);
            }
        } else {
            String path = getFilePath("/conf-log4j.properties");

            if (watchEnabled) {
                PropertyConfigurator.configureAndWatch(path);
            } else {
                PropertyConfigurator.configure(path);
            }
        }

    }

    /**
     * 获取文件路径
     *
     * @param fileName
     * @return
     */
    private static String getFilePath(String fileName) {

        URL url = Log4jUtil.class.getResource(fileName);
        String path = url.toString();
        return path.substring(path.indexOf(":") + 1, path.length());

    }

    public static void main(String[] args) throws Exception {

        configure("debug", "/home/antif/");
        configure("debug", "d:\\\\logs\\\\");

    }
}
