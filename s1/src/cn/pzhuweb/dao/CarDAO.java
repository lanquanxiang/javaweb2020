package cn.pzhuweb.dao;

import java.util.List;

import cn.pzhuweb.pojo.Car;

public interface CarDAO extends GeneralDAO<Car, Integer>{
	//模糊查询
	public List<Car> selectByKeyWords(String keywords); 
}
