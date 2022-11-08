package cn.pzhuweb.service;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;

public interface UserService {
	//根据实际业务来定义接口
	//注册
	public Message regist(User user);
	//登录
	public Message login(User user);
	//修改密码
	public Message changePassword(User user);
	//删除账户
	public Message removeCount(String name);
}
