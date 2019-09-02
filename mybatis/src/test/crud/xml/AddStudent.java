package test.crud.xml;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import entity.Student;
/*基于mapper配置文件进行crud操作*/
public class AddStudent {
	@Test
	public void addStudentTest() throws IOException{
		//1.指定要加载的文件名
		String resource="mybatis-config.xml";
		//2.加载配置文件(有两种方法：1.通过mybatis的Resources的工具类，2.任意的输入流实例)
		InputStream in=Resources.getResourceAsStream(resource);
		//3.通过SqlSessionFactoryBuilder及配置文件构建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//4.创建能执行映射文件中SQL语句的SqlSession
		SqlSession session=factory.openSession();
		//5.执行添加学生信息:根据映射文件mapper的对应的语句标签的id
		Student s=new Student();
		s.setId(2);
		s.setName("李四");
		s.setSex("F");
		s.setClassmate("软件");
		int i=session.insert("insertStudent", s);
		//6.提交事务（必须，否则数据库中未添加进该记录）
		session.commit();
		//7.关闭SqlSession
		session.close();
		System.out.println("表中受影响的行："+i);
	}
}
