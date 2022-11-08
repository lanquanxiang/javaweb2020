package cn.pzhuweb.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.pzhuweb.dao.UserDAO;
import cn.pzhuweb.pojo.User;
import cn.pzhuweb.util.DBUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public int insert(User t) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public int delete(String k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
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
