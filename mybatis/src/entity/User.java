package entity;
/*Mybaits是把getId方法名中的get去掉，I变小写，得到id字段，然后去匹配数据库
 * 中的id字段，而不是根据User对象的属性id来匹配，你把属性名id随便怎么改都行，但你
 * 要把getId方法的名字不能变*/
public class User {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
