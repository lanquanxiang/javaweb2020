package cn.pzhuweb.test.dao;

import java.util.List;

import cn.pzhuweb.test.pojo.Car;

public interface CarDAO extends GeneralDAO<Car, Integer>{
	//扩展了模糊查询的子接口方法
	public List<Car> selectByKeywords(String keywords);

}
