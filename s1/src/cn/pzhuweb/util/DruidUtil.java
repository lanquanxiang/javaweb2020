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
	//1. 声明数据源
		private static DataSource ds = null;
		//2. 初始化
		static{
			InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("druid.properties");
			Properties properties = new Properties();
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				ds = DruidDataSourceFactory.createDataSource(properties);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//3. 提供公有方法得到数据源
		public static DataSource getDs() {
			return ds;
		}
		//4. 提供公有方法得到连接
		public static Connection getConection(){
			try {
				return ds.getConnection();//从连接池中得到连接
			} catch (SQLException e) {
				e.printStackTrace();//连接池没有可用连接
				return null;
			} 
		}
		
		@Test
		public void test(){
			for (int i = 0; i < 10; i++) {
				Connection conn= null;
				try {
					conn = getDs().getConnection();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				System.out.println(i+":"+conn);				
			}
		}
}
