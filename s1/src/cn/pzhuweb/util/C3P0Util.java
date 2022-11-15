package cn.pzhuweb.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//1. 声明数据源
	private static DataSource ds = null;
	//2. 初始化
	static{
		ds=new ComboPooledDataSource();
		//ds = new ComboPooledDataSource("otherc3p0");
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
	public void test() throws SQLException{
		for (int i = 0; i <= 10; i++) {
			Connection conn = getConection();
			System.out.println(i+":"+conn);
			if (i==5) {
				conn.close();
			}
			
		}
	}
	
	
}
