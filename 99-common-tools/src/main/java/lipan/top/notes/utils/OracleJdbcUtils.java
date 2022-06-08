package lipan.top.notes.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
/**
 * @author li.pan
 * @title oracle jdbc工具类
 */
public class OracleJdbcUtils {
    // 表示定义数据库的用户名
    private static String USERNAME;

    // 定义数据库的密码
    private static String PASSWORD;

    // 定义数据库的驱动信息
    private static String DRIVER;

    // 定义访问数据库的地址
    private static String URL;

    // 数据库连接
    private Connection connection;

    // 数据库的执行对象
    private PreparedStatement preparedStatement;

    // 数据库返回的结果集
    private ResultSet resultSet;

    // 初始化配置文件
    public OracleJdbcUtils() {
        System.out.println("开始加载数据库配置文件");
        try {
            InputStream inputStream = OracleJdbcUtils.class
                    .getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            USERNAME = properties.getProperty("jdbc.username");
            PASSWORD = properties.getProperty("jdbc.password");
            DRIVER = properties.getProperty("jdbc.driver");
            URL = properties.getProperty("jdbc.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("数据库配置文件加载成功");
    }

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("获取数据库连接成功，connection：" + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 执行更新（包括了删除，增加）操作
     *
     * @param sql    sql语句
     * @param params 执行参数
     * @return 执行结果
     * @throws SQLException
     */
    public boolean updateByPreparedStatement(String sql, List<?> params)
            throws SQLException {
        boolean flag = false;
        int result = -1; // 表示当用户执行添加删除和修改的时候所影响数据库的行数
        preparedStatement = connection.prepareStatement(sql);
        int index = 1;
        // 填充sql语句中的占位符
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        result = preparedStatement.executeUpdate();
        flag = result > 0 ? true : false;
        return flag;
    }

    /**
     * 执行查询操作
     *
     * @param sql    sql语句
     * @param params 执行参数
     * @return
     * @throws SQLException
     */
    public List<Map<String, Object>> findResult(String sql, List<?> params)
            throws SQLException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int index = 1;
        preparedStatement = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        // 获取查询出来的数据的列数
        int cols_len = metaData.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < cols_len; i++) {
                // 获取列名（字段名）
                String cols_name = metaData.getColumnName(i + 1);
                // 获取该列的值
                Object cols_value = resultSet.getObject(cols_name);
                if (cols_value == null) {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }
        return list;
    }

    /**
     * 释放资源
     */
    public void releaseConn() {
        System.out.println("开始释放数据库资源");
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据库资源释放成功");
    }

    public static void main(String[] args) {
        OracleJdbcUtils OracleJdbcUtils = new OracleJdbcUtils();
        OracleJdbcUtils.getConnection();
        try {
            // 增加数据
            List<Object> paramsInsert = new ArrayList<Object>();
            paramsInsert.add("测试");
            paramsInsert.add(23);
            boolean resultInsert = OracleJdbcUtils.updateByPreparedStatement("insert into user_info(user_name, age) values(?, ?)", paramsInsert);
            System.out.println(resultInsert);

            // 删除数据
            List<Object> paramsDelete = new ArrayList<Object>();
            paramsDelete.add(20);
            boolean resultDelete = OracleJdbcUtils.updateByPreparedStatement("delete from user_info where id = ?", paramsDelete);
            System.out.println(resultDelete);

            // 更新数据
            List<Object> paramsUpdate = new ArrayList<Object>();
            paramsUpdate.add(26);
            paramsUpdate.add(3);
            boolean result = OracleJdbcUtils.updateByPreparedStatement("update user_info set age = ? where id = ?", paramsUpdate);
            System.out.println(result);

            // 查询数据
            List<Object> paramsFind = new ArrayList<Object>();
            paramsFind.add(6);
            List<Map<String, Object>> resultFind = OracleJdbcUtils.findResult(
                    "select * from user_info where id = ?", paramsFind);
            for (Map<String, Object> m : resultFind) {
                System.out.println(m);
            }
            //System.out.println(result.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            OracleJdbcUtils.releaseConn();
        }
    }
}
