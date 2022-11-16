package cn.pzhuweb.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.pzhuweb.dao.UserDAO;
import cn.pzhuweb.pojo.User;
import cn.pzhuweb.util.C3P0Util;
import cn.pzhuweb.util.JDBCUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public int insert(User t) {
		Connection con = C3P0Util.getConnection();
		PreparedStatement psta = null;		
		
		String sql="insert into user values(?,?)";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, t.getName());
			psta.setString(2, t.getPassword());			
			return psta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			JDBCUtil.close(psta, con);
		}
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
	public List<User> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(String k) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement psta = null;
		ResultSet res = null;
		
		String sql="select * from user where name=?";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, k);
			res = psta.executeQuery();
			if (res.next()) {
				String name = res.getString(1);
				String password = res.getString(2);
				return new User(name, password);//dbUser
			}else{
				return null;//用户不存在
			}
		} catch (Exception e) {
			return null;
		}finally {
			JDBCUtil.close(res, psta, con);
		}
	}

}
