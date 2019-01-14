package _01.dao.impl;

import _01.dao.IResultSetHandler;
import _01.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTemplate {
    public JdbcTemplate() {
    }

    public static int update(String sql, Object... objects) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for (int index = 0; index < objects.length; index++) {
                ps.setObject(index + 1, objects[index]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, ps, null);
        }
        return 0;
    }
    public static <T> T query(String sql, IResultSetHandler<T> rsh, Object... objects) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for (int index = 0; index < objects.length; index++) {
                ps.setObject(index + 1, objects[index]);
            }
            rs = ps.executeQuery();
            return rsh.handler(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, ps, rs);
        }
        return null;
    }
}
