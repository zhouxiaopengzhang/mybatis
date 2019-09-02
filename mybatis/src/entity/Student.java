package entity;

public class Student {
	private Integer id;
	private String name;
	private String sex;
	private String classmate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassmate() {
		return classmate;
	}
	public void setClassmate(String classmate) {
		this.classmate = classmate;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", classmate=" + classmate + "]";
	}
	
}
