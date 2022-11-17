package cn.pzhuweb.test.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//1.声明数据源
	private static DataSource ds = null;
	//2.初始化
	static{
		ds = new ComboPooledDataSource();
	}
	//3.获得连接池
	public static DataSource getDs() {
		return ds;
	}
	
	//4.从连接池得到连接
	public static Connection getConnection(){
		try {
			return ds.getConnection();//从连接池得到连接
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Test
	public void test(){
		for (int i = 0; i < 11; i++) {
			Connection con = getConnection();
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
