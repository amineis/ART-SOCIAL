package dao;

import java.sql.*;


public class LikeDao {

    Connection con;

    public LikeDao(Connection con) {
        this.con = con;
    }

    public boolean insertLike(String liker, int post_id) {
        boolean f = false;
        try {
            String q = "insert into likes(liker,post_id)values(?,?)";
            PreparedStatement p = this.con.prepareStatement(q);
            //values set...
            p.setString(1, liker);
            p.setInt(2, post_id);
            p.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public int countLikeOnPost(int post_id) {
        int count = 0;

        String q = "select count(*) from likes where post_id=?";
        try {
            PreparedStatement p = this.con.prepareStatement(q);
            p.setInt(1, post_id);
            ResultSet set = p.executeQuery();
            if (set.next()) {
                count = set.getInt("count(*)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public boolean isLikedByUser(int post_id, String liker) {
        boolean f = false;
        try {
            PreparedStatement p = this.con.prepareStatement("select * from likes where post_id=? and liker=?");
            p.setInt(1, post_id);
            p.setString(2, liker);
            ResultSet set = p.executeQuery();
            if (set.next()) {
                f = true;
            }

        } catch (Exception e) {
        }
        return f;
    }

    public boolean deleteLike(int post_id, String liker) {
        boolean f = false;
        try {
            PreparedStatement p = this.con.prepareStatement("delete from likes where post_id=? and liker=? ");
            p.setInt(1, post_id);
            p.setString(2, liker);
            p.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}