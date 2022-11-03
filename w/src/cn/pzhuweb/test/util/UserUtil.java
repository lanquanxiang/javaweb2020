package cn.pzhuweb.test.util;

import java.util.ArrayList;

import cn.pzhuweb.test.pojo.Message;
import cn.pzhuweb.test.pojo.UserInfo;

public class UserUtil {
	//1. 判断userinfo是否完整和合法	
	public static Message check(UserInfo userInfo){
		if (userInfo==null) {
			return new Message(false, "数据为null，不合法！");
		}
		if (userInfo.getUsername().equals("")) {
			return new Message(false, "用户名不能为空！");
		}
		//判断年龄1-150，爱好有没有选择
		//……
		return new Message(true, "数据合法!");
	}
	
	//2. 判断userinfo是否已经登记
	public static boolean isSave(String username, ArrayList<UserInfo> list){
		return false;
	}
	
	//3. 将userinfo放入登记表
	public static ArrayList<UserInfo> update(UserInfo userInfo,ArrayList<UserInfo> oldlist){
		ArrayList<UserInfo> newlist = new ArrayList<>();
		if (oldlist!=null) {
			newlist.addAll(oldlist);
		}
		newlist.add(userInfo);
		return newlist;
	}
	

}
