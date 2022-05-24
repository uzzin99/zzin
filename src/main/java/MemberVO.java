//database table과 같은구조 
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String mobile;
	private String joindate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoinDate(String joindate) {
		this.joindate = joindate;
	}

}
