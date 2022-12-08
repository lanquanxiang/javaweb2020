package cn.pzhuweb.test.util;

import java.util.ArrayList;
import java.util.List;

import cn.pzhuweb.test.pojo.Car;

public class PageUtil {

	public static List<Car> splitList(List<Car> list, int page, int num) {
		if (list==null || list.size()==0) {
			return list;
		}
		if (num<=0) {
			num=10;
		}
		if (page<=0) {
			page=1;
		}
		int pages = (list.size()-1)/num+1;
		if (page>pages) {
			page = pages;
		}
		
		List<Car> pagelist = new ArrayList<>();
		for (int i = (page-1)*num; i < page*num && i<list.size(); i++) {
			pagelist.add(list.get(i));
		}	
		
		return pagelist;
	}

	public static StringBuffer getBar(List<Car> list, int page, int num, String path) {
		if (list==null || list.size()==0) {
			return null;
		}
		if (num<=0) {
			num=10;
		}
		if (page<=0) {
			page=1;
		}
		int pages = (list.size()-1)/num+1;
		if (page>pages) {
			page = pages;
		}
		
		StringBuffer bar = new StringBuffer();
		if (page>1) {
			bar.append("<a href='"+path+"?page="+(page-1)+"&num="+num+"'>←</a>");
		}
		for (int i = 1; i <= pages; i++) {
			if (page==i) {
				bar.append("["+i+"]");
			}else{
				bar.append("<a href='"+path+"?page="+i+"&num="+num+"'>"+i+"</a>");
			}
			
		}
		if (page<pages) {
			bar.append("<a href='"+path+"?page="+(page+1)+"&num="+num+"'>→</a>");
		}
		
		return bar;
	}

}
