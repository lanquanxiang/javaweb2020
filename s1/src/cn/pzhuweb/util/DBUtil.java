package cn.pzhuweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	
	static{
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConection(){
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(ResultSet res, Statement sta,Connection con){
		if (res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		if (sta!=null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet res, PreparedStatement sta,Connection con){
		close(res, (Statement)sta, con);
	}
	public static void close(Statement sta,Connection con){
		close(null, sta, con);
	}
	public static void close(PreparedStatement sta,Connection con){
		close(null, sta, con);
	}
	
}
