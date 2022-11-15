package cn.pzhuweb.service;

import java.util.List;

import cn.pzhuweb.pojo.Car;
import cn.pzhuweb.pojo.Message;

public interface CarService {
	//显示所有汽车的信息
	public List<Car> showAll();
	//更新汽车的信息
	public Message updateCarInfo(Car car);
	//删除汽车的信息
	public Message removeCarInfo(Integer id);
	//新增汽车的信息
	public Message addCarInfo(Car car);
	//模糊查询汽车的信息
	public List<Car> searchByKeywords(String keywords);
}
