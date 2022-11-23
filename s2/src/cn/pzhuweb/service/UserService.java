package cn.pzhuweb.service;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;

public interface UserService {
	//1.用户登录
	public Message login(User user);
	//2.用户注册
	public Message regist(User user);
	//3.修改密码
	public Message changePassword(User user);
	//4.销户
	public Message removeAccount(String name);
	//5.检测用户名是否被占用
	public boolean isRegist(String name);

}
