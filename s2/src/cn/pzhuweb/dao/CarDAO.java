package cn.pzhuweb.dao;

import java.util.List;

import cn.pzhuweb.pojo.Car;

public interface CarDAO extends GeneralDAO<Car, Integer>{
	public List<Car> selectByKeywords(String keywords);//扩展模糊查询的方法
}
