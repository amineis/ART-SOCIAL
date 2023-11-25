package model;

public class Follow {
	public int id;	
	public int follower_id;	
	public int following_id;
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Follow(int id, int follower_id, int following_id) {
		super();
		this.id = id;
		this.follower_id = follower_id;
		this.following_id = following_id;
	}
	public Follow(int follower_id, int following_id) {
		super();
		this.follower_id = follower_id;
		this.following_id = following_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFollower_id() {
		return follower_id;
	}
	public void setFollower_id(int follower_id) {
		this.follower_id = follower_id;
	}
	public int getFollowing_id() {
		return following_id;
	}
	public void setFollowing_id(int following_id) {
		this.following_id = following_id;
	}
	
	
	
	
	
	
	
}
