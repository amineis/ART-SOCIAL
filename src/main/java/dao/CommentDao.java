package dao;
import model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
	
	private Connection con;

    public CommentDao(Connection con) {
        this.con = con;
    }
    
    public boolean insertComment(Comment c) {
    	boolean f = false;
        try {

            String q = "INSERT INTO commentaire(author_id,c_post_id,content) VALUES(?,?,?)";
            PreparedStatement st = con.prepareStatement(q);
            st.setInt(1, c.getAuthor_id());
            st.setInt(2, c.getPost_id());
            st.setString(3, c.getContent());
            st.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    
    public ArrayList<Comment> getCommentsByPost(int postid) {

    	ArrayList<Comment> list = new ArrayList<>();
        //fetch all the post
        try {

            PreparedStatement p = con.prepareStatement("select * from commentaire where c_post_id=? order by c_id desc");
            p.setInt(1, postid);
            ResultSet set = p.executeQuery();

            while (set.next()) {

                int cid = set.getInt("c_id");
                int author = set.getInt("author_id");
                String content = set.getString("content");
                
                Comment comm = new Comment(cid, author, postid, content);

                list.add(comm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean deleteComment(int cid) {
    	boolean f = false;
        try {

            String q = "delete from commentaire where c_id=?";
            PreparedStatement st = con.prepareStatement(q);
            st.setInt(1, cid);
            st.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
