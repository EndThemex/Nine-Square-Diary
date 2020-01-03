package com.endtheme.ninesquarediary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {

    private static String jdbcDriver = "jdbc.driver"; // Database driver
    private static String jdbcUrlPath = "jdbc.url"; // Database connection url
    private static String jdbcUserName = "jdbc.username"; // Database user name
    private static String jdbcPassword = "jdbc.password"; // Database user password

    /**
     * Get database connection
     * @return connection
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(PropertyUtil.getProperty(jdbcDriver));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String jdbcUrl = PropertyUtil.getProperty(jdbcUrlPath);
        // Get Connection
        try {
            conn = DriverManager.getConnection(jdbcUrl, PropertyUtil.getProperty(jdbcUserName), PropertyUtil.getProperty(jdbcPassword));
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return conn;
    }

    public static void closeConnection(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void setAutoCommit(Connection conn, boolean autoCommit) {
        try {
            conn.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public static void commit(Connection conn) {
        try {
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public static void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }
}
