package cn.pzhuweb.test.service;

import cn.pzhuweb.test.pojo.Message;
import cn.pzhuweb.test.pojo.User;

public interface UserService {
	//1.登录
	public Message login(User user);
	//2.注册
	public Message regist(User user);
	//3.修改密码
	public Message changePassword(User newuser);
	//4.销户
	public boolean removeAccount(String name);
	//5. 检测用户名是否已经被注册
	public boolean isRegist(String name);
}
