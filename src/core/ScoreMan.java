package core;

import java.sql.*;

public class ScoreMan {
    private int uid, score;
    private Connection con;

    public ScoreMan(int uid) {
        this.uid = uid;
        this.con = getDBConnection();
        this.score = getScore();
    }

    // 数据库连接
    private Connection getDBConnection() {
        /* 数据库连接 */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/MyGomoku";
            return DriverManager.getConnection(url, "root", "Xyc982436");
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败");
        }
        return null;
    }

    private void closeDBConnection() throws Exception {
        /* 释放连接 */
        con.close();
    }

    // 积分操作
    public int getScore() {
        /* 查询积分 */
        try {
            String sql = "SELECT Score FROM Mygomuku.Users WHERE User_Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.uid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Score");
            } else {
                System.out.println("用户不存在");
            }
        } catch (SQLException e) {
            System.out.println("积分查询失败: " + e.getMessage());
        }
        return -1;
    }
    public void setScore(int value) {
        /* 设置积分 */
        try {
            String sql = "UPDATE Mygomuku.Users SET Score = ? WHERE User_Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, this.uid);
            ps.executeUpdate();
            this.score = value;
        } catch (SQLException e) {
            System.out.println("积分更新失败: " + e.getMessage());
        }
    }

}
