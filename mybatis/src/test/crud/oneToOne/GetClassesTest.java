package test.crud.oneToOne;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import entity.Classes;
/*暂时获取的数据为null*/
//通过classes获取teacher的信息
public class GetClassesTest {
	@Test
	public void getStudentTest() throws IOException{
		//1.指定要加载的文件名
		String resource="mybatis-config.xml";
		//2.加载配置文件(有两种方法：1.通过mybatis的Resources的工具类，2.任意的输入流实例)
		InputStream in=Resources.getResourceAsStream(resource);
		//3.通过SqlSessionFactoryBuilder及配置文件构建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//4.创建能执行映射文件中SQL语句的SqlSession
		SqlSession session=factory.openSession();
		//5.执行查询(有两种查询方式，嵌套结果与嵌套查询):根据映射文件mapper的对应的语句标签的id
		//第一种：嵌套结果
		Classes s=session.selectOne("selectClasses", 1);
		//第二种：嵌套查询
		Classes s2=session.selectOne("selectClasses2", 2);
		//6.提交事务（必须，否则数据库中未添加进该记录）
		session.commit();
		//7.关闭SqlSession
		session.close();
		System.out.println(s);
		System.out.println(s2);
	}
}
