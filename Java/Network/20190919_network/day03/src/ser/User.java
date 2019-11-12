package ser;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	transient private String pwd;
	//transient로 선언된 애는 string을 통과할 수 없음. 
	private int age;
	
	public User() {
		
	}
	
	public User(String id, String pwd, int age) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.age = age;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", age=" + age + "]";
	}
	
	
	
}
