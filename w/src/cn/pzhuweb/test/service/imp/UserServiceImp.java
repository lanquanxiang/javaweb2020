package cn.pzhuweb.test.service.imp;

import cn.pzhuweb.test.dao.UserDAO;
import cn.pzhuweb.test.dao.imp.UserDAOImp;
import cn.pzhuweb.test.pojo.Message;
import cn.pzhuweb.test.pojo.User;
import cn.pzhuweb.test.service.UserService;
import cn.pzhuweb.test.util.EmailUtil;

public class UserServiceImp implements UserService{
	private UserDAO dao = new UserDAOImp();

	@Override
	public Message login(User user) {
		if (user==null) {
			return new Message(false, "数据不合法!");
		}
		if ("".equals(user.getName()) || "".equals(user.getPassword())) {
			return new Message(false, "用户名或者密码为空!");
		}
		User dbUser = dao.selectById(user.getName());
		if (dbUser==null) {
			return new Message(false, "此用户不存在!");
		}
		if (!dbUser.getPassword().equals(user.getPassword())) {
			return new Message(false, "密码错误!");
		}
		return new Message(true, "登录成功!");
	}

	@Override
	public Message regist(User user) {
		if (user==null) {
			return new Message(false, "数据不合法!");
		}
		if ("".equals(user.getName()) || "".equals(user.getPassword())) {
			return new Message(false, "用户名或者密码为空!");
		}
		User dbUser = dao.selectById(user.getName());
		if (dbUser!=null) {
			return new Message(false, "此用户已经存在!");
		}
		if (dao.insert(user)==0) {
			return new Message(false, "注册失败!");
		}
		return new Message(true, "注册成功，请登录!");
	}

	@Override
	public Message changePassword(User newuser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAccount(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRegist(String name) {
		if (dao.selectById(name)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Message sendEmail(String username, String email) {
		if (username==null||email==null) {
			return new Message(false, "数据不合法!");
		}
		if ("".equals(username)||"".equals(email)) { // ||邮箱的格式不正确（正则表达式）
			return new Message(false,"用户名或邮箱不能为空!");
		}
		User dbuser = dao.selectById(username);
		if (dbuser==null) { // || !dbuser.getEmail().equals(email) 需要判断用户输入的邮箱是否正确
			return new Message(false, "用户名不存在或邮箱不正确!");
		}
		return EmailUtil.sendEmail(email);
	}

}
