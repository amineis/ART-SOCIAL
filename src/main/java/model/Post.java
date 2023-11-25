package model;
import java.io.InputStream;
import java.sql.*;
public class Post {

	public int id;	
	public int author_id;
	public InputStream img;
	public Date time;
	public String type;
	public String title;
	public String desc;
	public int likes;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(int id, int author_id, InputStream img, Date time, String type, String title, String desc, int likes) {
		super();
		this.id = id;
		this.author_id = author_id;
		this.img = img;
		this.time = time;
		this.type = type;
		this.title = title;
		this.desc = desc;
		this.likes = likes;
	}
	public Post(int author_id, InputStream img, Date time, String type, String title, String desc, int likes) {
		super();
		this.author_id = author_id;
		this.img = img;
		this.time = time;
		this.type = type;
		this.title = title;
		this.desc = desc;
		this.likes = likes;
	}
	public Post(int author_id, InputStream img, Date time, String type, String title, String desc) {
		super();
		this.author_id = author_id;
		this.img = img;
		this.time = time;
		this.type = type;
		this.title = title;
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public InputStream getImg() {
		return img;
	}
	public void setImg(InputStream img) {
		this.img = img;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
	
	
	
	
	
	
	
	
}
