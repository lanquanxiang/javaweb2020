package cn.pzhuweb.test.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.pzhuweb.test.dao.UserDAO;
import cn.pzhuweb.test.pojo.User;
import cn.pzhuweb.test.util.C3P0Util;
import cn.pzhuweb.test.util.JDBCUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public int insert(User t) {
		Connection con = C3P0Util.getConnection();
		PreparedStatement psta = null;
		try {
			String sql="insert into user values(?,?)";
			psta=con.prepareStatement(sql);
			
			psta.setString(1, t.getName());
			psta.setString(2, t.getPassword());
			return psta.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			JDBCUtil.close(psta,con);
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
	public User selectById(String k) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement psta = null;
		ResultSet res = null;
		try {
			String sql="select * from user where name=?";
			psta=con.prepareStatement(sql);
			
			psta.setString(1, k);
			res = psta.executeQuery();
			
			if (res.next()) {
				String name = res.getString(1);
				String password = res.getString(2);
				return new User(name, password);//查到的dbUser
			}else{
				return null;//没有查到用户
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(res,psta,con);
		}
	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
