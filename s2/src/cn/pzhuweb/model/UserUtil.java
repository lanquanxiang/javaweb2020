package cn.pzhuweb.model;

import java.util.ArrayList;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.UserInfo;

public class UserUtil {
	//1.判断userinfo的信息是否合法
	public static Message check(UserInfo userInfo){
		if (userInfo==null) {
			return new Message(false, "用户数据不合法!");
		}
		if(userInfo.getUsername().equals("")){
			return new Message(false, "用户名不能为空!");
		}
		//判断年龄是正数 200岁
		//判断爱好是选了的
		return new Message(true, "数据合法");
	}
	
	//2.判断username是否已经被登记
	/**
	 * 
	 * @param username
	 * @param list
	 * @return 如果username已经在list中，则返回true，否则返回false
	 */
	public static boolean isSave(String username,ArrayList<UserInfo> list){
		return false;
	}
	
	//3.将userinfo放入登记表中
	public static ArrayList<UserInfo> add(UserInfo userInfo,ArrayList<UserInfo> oldlist){
		ArrayList<UserInfo> newlist = new ArrayList<UserInfo>();
		return newlist;
	}

}
