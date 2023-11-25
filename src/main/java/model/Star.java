package model;

public class Star {
	public int id;	
	public int u_id;	
	public int p_id;
	public Star() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Star(int s_id, int u_id, int p_id) {
		super();
		this.id = s_id;
		this.u_id = u_id;
		this.p_id = p_id;
	}
	public Star(int u_id, int p_id) {
		super();
		this.u_id = u_id;
		this.p_id = p_id;
	}
	public int getS_id() {
		return id;
	}
	public void setS_id(int s_id) {
		this.id = s_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}	

	
}
