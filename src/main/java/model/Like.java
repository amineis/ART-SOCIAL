package model;

public class Like {
	public int id;	
	public String liker;
	public int post_id	;
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(int id, String liker, int post_id) {
		super();
		this.id = id;
		this.liker = liker;
		this.post_id = post_id;
	}
	public Like(String liker, int post_id) {
		super();
		this.liker = liker;
		this.post_id = post_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLiker() {
		return liker;
	}
	public void setLiker(String liker) {
		this.liker = liker;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	
	
}
