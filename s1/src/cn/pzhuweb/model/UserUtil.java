package cn.pzhuweb.model;

import java.util.ArrayList;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.SUser;

public class UserUtil {
	//1.检验数据的合法性
	public static Message check(SUser user){
		if (user==null) {
			return new Message(false, "用户信息不合法！");
		}
		if(user.getUsername().equals("")){
			return new Message(false, "用户名不能为空！");
		}
		// 判断爱好、判断年龄
		return new Message(true, "数据合法");
	}
	
	//2.检验用户是否已经登记
	/**
	 * 
	 * @param username
	 * @param list
	 * @return 如果已经被登记，返回true，没有登记，返回false
	 */
	public static boolean isRegist(String username,ArrayList<SUser> list){
		return false;
	}
	
	//3.将新用户登记入用户表中
	/**
	 * 
	 * @param user 要存入的用户
	 * @param list 旧的登记表（有可能为null）
	 * @return 新的登记表
	 */
	public static ArrayList<SUser> add(SUser user,ArrayList<SUser> list){
		return null;
	}

}
