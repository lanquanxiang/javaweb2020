package cn.pzhuweb.service;

import java.util.List;

import cn.pzhuweb.pojo.Car;
import cn.pzhuweb.pojo.Message;

public interface CarService {
	//1. 显示所有汽车信息
	public List<Car> showAllCarInfo();
	//2. 删除制定id的汽车信息
	public Message removeCarInfo(Integer id);
	//3. 编辑汽车信息
	public Message editCarInfo(Car car);
	//4. 插入汽车信息
	public Message addCarInfo(Car car);
	//5. 按照关键字来进行查询
	public List<Car> searchCarInfoByKeywords(String keywords);
}
