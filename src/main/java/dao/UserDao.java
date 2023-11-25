package dao;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import model.User;

public class UserDao {
	private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }

    //method to insert user to data base:
    public boolean saveUser(User user) {
        boolean f = false;
        try {
            //user -->database

            String query = "insert into user(username,pass,email) values (?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getMdp());

            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

    //get user by useremail and userpassword:
    public User getUserByEmailAndPassword(String email, String mdp) {
        User user = null;

        try {

            String query = "select * from user where email =? and pass=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, mdp);

            ResultSet set = pstmt.executeQuery();
            if (set.next()) {
                user = new User();

                user.setName(set.getString("full_name"));
                user.setId(set.getInt("user_id"));
                user.setEmail(set.getString("email"));
                user.setMdp(set.getString("pass"));
                user.setGender(set.getString("gender"));
                user.setUsername(set.getString("username"));
                user.setFollowers(set.getInt("followers"));
                user.setImage(set.getBinaryStream("image"));
                user.setCountry(set.getString("country"));
                user.setAdmin(set.getString("admin"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean updateUser(User user) {

        boolean f = false;
        try {

            String query = "update user set full_name=? , username=? , pass=? , email=? ,image=? , country=? , gender=? where  user_id =?";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, user.getName());
            p.setString(2, user.getUsername());
            p.setString(3, user.getMdp());
            p.setString(4, user.getEmail());
            p.setBlob(5, user.getImage());
            p.setString(6, user.getCountry());
            p.setString(7, user.getGender());
            p.setInt(8, user.getId());

            p.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public User getUserByUserId(int userId) {
        User user = null;
        try {
            String q = "select * from user where user_id=?";
            PreparedStatement ps = this.con.prepareStatement(q);
            ps.setInt(1, userId);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                user = new User();

//             data from db
//             set to user object
                user.setName(set.getString("full_name"));
                user.setId(set.getInt("user_id"));
                user.setEmail(set.getString("email"));
                user.setMdp(set.getString("pass"));
                user.setGender(set.getString("gender"));
                user.setUsername(set.getString("username"));
                user.setFollowers(set.getInt("followers"));
                user.setCountry(set.getString("country"));
                user.setAdmin(set.getString("admin"));
                user.setImage(set.getBinaryStream("image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

	
	
	
	
	
	
	
	
	
	
	
	
}
