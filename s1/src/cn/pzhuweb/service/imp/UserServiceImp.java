package cn.pzhuweb.service.imp;

import cn.pzhuweb.dao.UserDAO;
import cn.pzhuweb.dao.imp.UserDAOImp;
import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;
import cn.pzhuweb.service.UserService;
import cn.pzhuweb.util.EmailUtil;

public class UserServiceImp implements UserService{
	
	private UserDAO dao = new UserDAOImp();

	@Override
	public Message regist(User user) {
		if (user==null) {
			return new Message(false,"数据合法！");
		}
		if ("".equals(user.getName()) || "".equals(user.getPassword())) {
			return new Message(false,"用户名或密码不能为空！");
		}
		User dbUser = dao.selectById(user.getName());
		if (dbUser!=null) {
			return new Message(false,"用户名已经被注册！");
		}
		int n = dao.insert(user);
		if(n==0){
			return new Message(false,"注册失败！");
		}
		return new Message(true,"注册成功，请登录！");
	}

	@Override
	public Message login(User user) {
		if (user==null) {
			return new Message(false,"数据合法！");
		}
		if ("".equals(user.getName()) || "".equals(user.getPassword())) {
			return new Message(false,"用户名或密码不能为空！");
		}
		User dbUser = dao.selectById(user.getName());
		if (dbUser==null) {
			return new Message(false,"用户名不存在！");
		}
		if(!dbUser.getPassword().equals(user.getPassword())){
			return new Message(false,"密码错误！");
		}
		return new Message(true,"登录成功！");
	}

	@Override
	public Message changePassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message removeCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsed(String username) {
		if(dao.selectById(username)==null){
			return false;
		}
		return true;
	}

	@Override
	public Message sendemail(String username, String email) {
		if (username==null || email==null || "".equals(username) || "".equals(email)) {
			return new Message(false, "信息不完整!");
		}
		if (dao.selectById(username)==null) {//项目开发中还需要验证邮箱是否是这个用户的
			return new Message(false, "账号不存在!");
		}
		
		return EmailUtil.sendEmail(email);
	}

}
