package cn.pzhuweb.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.pzhuweb.dao.UserDAO;
import cn.pzhuweb.pojo.User;
import cn.pzhuweb.util.C3P0Util;
import cn.pzhuweb.util.DBUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public int insert(User t) {
		Connection con = C3P0Util.getConection();
		String sql = "insert into user values(?,?)";
		PreparedStatement psta = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, t.getName());
			psta.setString(2, t.getPassword());
			return psta.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(psta, con);
		}		
		return 0;
	}
	

	@Override
	public int delete(String k) {
		Connection con = DBUtil.getConection();
		String sql = "DELETE FROM user WHERE name = ?";
		PreparedStatement psta = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, k);
			return psta.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(psta, con);
		}		
		return 0;
	}

	@Override
	public int update(User t) {
		Connection con = DBUtil.getConection();
		String sql = "UPDATE user SET password = ? WHERE name = ?";
		PreparedStatement psta = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setString(2, t.getName());
			psta.setString(1, t.getPassword());
			return psta.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(psta, con);
		}		
		return 0;
	}

	@Override
	public User selectById(String k) {
		Connection con = DBUtil.getConection();
		String sql = "select * from user where name=?";
		PreparedStatement psta = null;
		ResultSet res = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, k);
			res = psta.executeQuery();
			if (res.next()) {
				String name = res.getString(1);
				String password = res.getString(2);
				return new User(name, password);
			}else {
				return null;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(res, psta, con);
		}
		
		return null;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
