package dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
    private static DataSource dataSource;

    static {
        try {
            // 使用 JNDI 查找数据源
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/drivingSchoolDB");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化数据源失败：" + e.getMessage());
        }
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 关闭数据库连接
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
