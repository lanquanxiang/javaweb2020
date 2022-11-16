package cn.pzhuweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil {
	//1.声明数据源
		private static DataSource ds = null;
		//2.初始化
		static{
			InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
			Properties pro = new Properties();
			try {
				pro.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				ds = DruidDataSourceFactory.createDataSource(pro);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//3.提供get方法
		public static DataSource getDs() {
			return ds;
		}
		//4.提供connection的获得方法
		public static Connection getConnection(){
			try {
				return ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		//单元测试
		@Test
		public void test(){
			for (int i = 0; i <= 10; i++) {
				Connection con =  getConnection();
				System.out.println(i+":"+con);			
				if (i==5) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
}
