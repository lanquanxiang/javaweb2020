package cn.pzhuweb.util;

import java.util.ArrayList;
import java.util.List;

import cn.pzhuweb.pojo.Car;

public class PageUtil {
	
	public static List<Car> splitList(List<Car> allList,int page,int num){
		if (page<=0) {
			page=1;
		}
		if (num<=0) {
			num=10;
		}		
		int pages = (allList.size()-1)/num+1;
		if (page>pages) {
			page=pages;
		}		
		if (allList==null || allList.size()==0) {
			return allList;
		}
		List<Car> list = new ArrayList<>();
		for (int i = (page-1)*10; i < page*10 && i<allList.size(); i++) {
			list.add(allList.get(i));
		}		
		return list;
	}
	
	public static StringBuffer  getBar  (List<Car> allList,int page,int num){
		if (page<=0) {
			page=1;
		}
		if (num<=0) {
			num=10;
		}		
		int pages = (allList.size()-1)/num+1;
		if (page>pages) {
			page=pages;
		}		
		if (allList==null || allList.size()==0) {
			return null;
		}
		
		StringBuffer bar = new StringBuffer();
		if (page>1) {
			bar.append("<a href='showcar?page="+(page-1)+"&num="+num+"'>上一页</a>  ");
		}
		for (int i = 1; i <= pages; i++) {
			if (i==page) {
				bar.append("  ["+i+"]  ");
			}else{
				bar.append("<a href='showcar?page="+i+"&num="+num+"'>"+i+"</a>  ");
			}
		}
		if (page<pages) {
			bar.append("<a href='showcar?page="+(page+1)+"&num="+num+"'>下一页</a>");
		}
		
		return bar;
		
	}
	
	
}
