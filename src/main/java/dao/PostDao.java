package dao;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Post;


public class PostDao {
	private Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }
    
    public boolean insertPost(Post p) {
    	boolean f = false;
        try {

            String q = "INSERT INTO post(author_id,p_img,p_time,p_type,p_title,p_desc) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(q);
            statement.setInt(1, p.getAuthor_id());
            statement.setBlob(2, p.getImg());
            statement.setDate(3, p.getTime());
            statement.setString(4, p.getType());
            statement.setString(5, p.getTitle());
            statement.setString(6, p.getDesc());
            statement.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    
    public ArrayList<Post> getAllPosts() {

    	ArrayList<Post> list = new ArrayList<>();
        //fetch all the post
        try {

            PreparedStatement p = con.prepareStatement("select * from post order by p_id desc");

            ResultSet set = p.executeQuery();

            while (set.next()) {

                int pid = set.getInt("p_id");
                int authorid = set.getInt("author_id");
                String title = set.getString("p_title");
                InputStream image = set.getBinaryStream("p_img");
                Date time = set.getDate("p_time");
                String type = set.getString("p_type");
                String desc = set.getString("p_desc");
                int likes = set.getInt("p_likes");
                
                Post post = new Post(pid , authorid , image, time, type, title, desc, likes);

                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Post> getPostByCat(String type) {
    	ArrayList<Post> list = new ArrayList<>();
        //fetch all post by id
        //fetch all the post
        try {

            PreparedStatement p = con.prepareStatement("select * from post where p_type=?");
            p.setString(1, type);
            ResultSet set = p.executeQuery();

            while (set.next()) {

            	int pid = set.getInt("p_id");
                int authorid = set.getInt("author_id");
                String title = set.getString("p_title");
                InputStream image = set.getBinaryStream("p_img");
                Date time = set.getDate("p_time");
                String desc = set.getString("p_desc");
                int likes = set.getInt("p_likes");
                
                Post post = new Post(pid , authorid , image, time, type, title, desc, likes);

                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int countPost(int user_id) {
        int count = 0;

        String q = "select count(*) from post where author_id=?";
        try {
            PreparedStatement p = this.con.prepareStatement(q);
            p.setInt(1, user_id);
            ResultSet set = p.executeQuery();
            if (set.next()) {
                count = set.getInt("count(*)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    
    public Post getPostByPostId(int postId) {
        Post post = null;
        try {
        	String q = "select * from post where p_id=?";
            PreparedStatement p = this.con.prepareStatement(q);
            p.setInt(1, postId);

            ResultSet set = p.executeQuery();

            if (set.next()) {

                int authorid = set.getInt("author_id");
                String title = set.getString("p_title");
                InputStream image = set.getBinaryStream("p_img");
                Date time = set.getDate("p_time");
                String type = set.getString("p_type");
                String desc = set.getString("p_desc");
                int likes = set.getInt("p_likes");
                
                post = new Post(postId , authorid , image, time, type, title, desc, likes);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
