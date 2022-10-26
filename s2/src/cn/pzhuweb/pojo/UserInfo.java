package cn.pzhuweb.pojo;

public class UserInfo {
	private String username;
	private Integer age;
	private String[] hobby;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String username, Integer age, String[] hobby) {
		super();
		this.username = username;
		this.age = age;
		this.hobby = hobby;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	

}
