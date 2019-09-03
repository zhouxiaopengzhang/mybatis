package generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//执行过程中的警告信息
		List<String> warnings=new ArrayList<String>();
		//生成的代码重复时，覆盖源码
		boolean overwrite=true;
		//读取配置文件
		InputStream in=Generator.class.getResourceAsStream("/generator/mybatis-generator-config.xml");
		ConfigurationParser cp=new ConfigurationParser(warnings);
		Configuration config=cp.parseConfiguration(in);
		in.close();
		
		DefaultShellCallback callback=new DefaultShellCallback(overwrite);
		//创建代码生成器
		MyBatisGenerator mybatisGenerator=new MyBatisGenerator(config, callback, warnings);
		//执行生成代码
		mybatisGenerator.generate(null);
		//输出警告信息
		for(String warning : warnings){
			System.out.println(warning);
		}
		
	}

}
