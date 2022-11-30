package cn.pzhuweb.util;

import java.util.ArrayList;
import java.util.List;

import cn.pzhuweb.pojo.Car;

public class PageUtil {
	//将完整的list分割为小的list
	public static List<Car> splitList(List<Car> allList,int page,int num){
		if (allList==null || allList.size()==0) {
			return allList;
		}
		if (page<1) {
			page=1;
		}
		int pages= (allList.size()-1)/num+1;
		if (page>pages) {
			page=pages;
		}
		if (num<1) {
			num=10;
		}
		List<Car> list = new ArrayList<>();
		for (int i = (page-1)*num; i < page*num && i<allList.size(); i++) {
			list.add(allList.get(i));
		}
		return list;
	}
}
