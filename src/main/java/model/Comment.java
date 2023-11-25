package model;

public class Comment {
	public int id;	
	public int author_id;	
	public int post_id;
	public String content;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int id, int author_id, int post_id, String content) {
		super();
		this.id = id;
		this.author_id = author_id;
		this.post_id = post_id;
		this.content = content;
	}
	public Comment(int author_id, int post_id, String content) {
		super();
		this.author_id = author_id;
		this.post_id = post_id;
		this.content = content;
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
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
