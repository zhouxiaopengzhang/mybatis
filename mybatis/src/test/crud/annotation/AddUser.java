package test.crud.annotation;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import entity.User;
import mapper.UserMapper;

public class AddUser {
	@Test
	public void addUserTest() throws IOException{
		//1.指定要加载的文件名
		String resource="mybatis-config.xml";
		//2.加载配置文件(有两种方法：1.通过mybatis的Resources的工具类，2.任意的输入流实例)
		InputStream in=Resources.getResourceAsStream(resource);
		//3.通过SqlSessionFactoryBuilder及配置文件构建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//4.创建能执行映射文件中SQL语句的SqlSession
		SqlSession session=factory.openSession();
		/*5.得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象
		 * 由sqlSession.getMapper(UserMapperI.class)动态构建出来*/
		UserMapper userMapper=session.getMapper(UserMapper.class);
		//创建要添加的对象
		User user=new User();
		user.setId(2);
		user.setName("李四");
		//向数据库添加用户信息
		userMapper.insertUser(user);
		//6.提交事务（必须，否则数据库中未添加进该记录）
		session.commit();
		//7.关闭SqlSession
		session.close();
	}
}
