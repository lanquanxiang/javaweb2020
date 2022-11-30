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
	public Message login(User user) {
		if (user==null) {
			return new Message(false, "数据不合法!");
		}
		if("".equals(user.getName())||"".equals(user.getPassword())){
			return new Message(false, "用户名或密码不能为空！");
		}
		User dbUser = dao.selectById(user.getName());
		if (dbUser==null) {
			return new Message(false, "用户名不存在！");
		}
		if(!dbUser.getPassword().equals(user.getPassword())){
			return new Message(false, "密码错误！");
		}
		return new Message(true, "登录成功！");
	}

	@Override
	public Message regist(User user) {
		if (user==null) {
			return new Message(false, "数据不合法!");
		}
		if("".equals(user.getName())||"".equals(user.getPassword())){
			return new Message(false, "用户名或密码不能为空！");
		}
		User dbUser = dao.selectById(user.getName());
		if (dbUser!=null) {
			return new Message(false, "用户名已经被注册！");
		}
		int n = dao.insert(user);
		if(n==0){
			return new Message(false, "注册失败！");
		}
		return new Message(true, "注册成功，请登录！");
	}

	@Override
	public Message changePassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message removeAccount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRegist(String name) {
		if(dao.selectById(name)!=null){
			return true;
		}
		return false;
	}

	@Override
	public Message sendEmail(String name, String email) {
		/*
		 * 1. 检验数据的完整性
		 * 2. 数据的合法性（用户名和邮箱是否与注册的一致）--用户名是否存在
		 * 3. 发送验证码（失败：message保存失败的信息；成功：message保存验证码）
		 */
		if (name==null || email==null || "".equals(name) || "".equals(email)) {
			return new Message(false,"信息不完整!");
		}
		User dbUser = dao.selectById(name);
		if (dbUser==null) {/*只验证了用户名，以后还需要验证邮箱是否一致 || !email.equals(dbUser.getEmail())   */
			return new Message(false,"用户不存在!");
		}
		
		return EmailUtil.sendEmail(email);
	}

}
