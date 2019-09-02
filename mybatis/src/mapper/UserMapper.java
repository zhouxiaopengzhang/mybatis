package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.User;

/*
 *使用注解的方式进行crud操作步骤如下：
 *	1.定义一个接口（定义一些执行crud的方法） 
 *	2.给每个方法添加相应的增删改查的注解，比如@Select
 *	3.在配置文件中通过<mapper>标签的class属性指定注册该自定义的映射接口
 */
/*该接口的功能相当于mapper.xml映射文件*/
//我们不需要实现该接口，mybatis会当我们动态创建实现类
public interface UserMapper {
	@Insert(value="insert into user(id,name) values(#{id},#{name})")
	public void insertUser(User user);
	
	@Delete(value="delete from user where id=#{id}")
	public void deleteUser(int id);

	@Update(value="update user set name=#{name} where id=#{id}")
	public void updateUser(User user);

	@Select(value="select * from user where id=#{id}")
	public void selectUser(int id);
	
}
